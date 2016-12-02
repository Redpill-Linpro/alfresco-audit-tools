package org.redpill.alfresco.repo.audit.scripts;

import java.util.Map;
import static org.alfresco.repo.web.scripts.audit.AbstractAuditWebScript.PARAM_VALUE;
import org.alfresco.repo.web.scripts.audit.AuditQueryGet;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.NamespaceService;
import org.alfresco.util.ISO9075;
import org.springframework.extensions.surf.util.Content;
import org.springframework.extensions.webscripts.Cache;
import org.springframework.extensions.webscripts.Description;
import org.springframework.extensions.webscripts.Match;
import org.springframework.extensions.webscripts.Runtime;
import org.springframework.extensions.webscripts.Status;
import org.springframework.extensions.webscripts.WebScriptException;
import org.springframework.extensions.webscripts.WebScriptRequest;

/**
 *
 * @author Marcus Svartmark - Redpill Linpro AB
 */
public class AuditNodeQueryGet extends AuditQueryGet {

  protected NodeService nodeService;
  protected NamespaceService namespaceService;

  @Override
  protected Map<String, Object> executeImpl(WebScriptRequest req, Status status, Cache cache) {
    String value = getParamValue(req);
    if (!NodeRef.isNodeRef(value)) {
      throw new WebScriptException(Status.STATUS_BAD_REQUEST, "Value is not a valid nodeRef");
    }
    NodeRef nodeRef = new NodeRef(value);
    //Do some magic to translate the node ref to a valid path for use in audit query
    final String nodePath = ISO9075.decode(nodeService.getPath(nodeRef).toPrefixString(namespaceService));
    ProxyWebScriptRequest proxyRequest = new ProxyWebScriptRequest(req);
    proxyRequest.setValueParam(nodePath);
    return super.executeImpl(proxyRequest, status, cache);
  }

  public void setNodeService(NodeService nodeService) {
    this.nodeService = nodeService;
  }

  public void setNamespaceService(NamespaceService namespaceService) {
    this.namespaceService = namespaceService;
  }

  public class ProxyWebScriptRequest implements WebScriptRequest {

    private WebScriptRequest originalRequest = null;
    private String valueParam;

    private ProxyWebScriptRequest(WebScriptRequest req) {
      originalRequest = req;
    }

    @Override
    public Match getServiceMatch() {
      return originalRequest.getServiceMatch();
    }

    @Override
    public String getServerPath() {
      return originalRequest.getServerPath();
    }

    @Override
    public String getContextPath() {
      return originalRequest.getContextPath();
    }

    @Override
    public String getServiceContextPath() {
      return originalRequest.getServiceContextPath();
    }

    @Override
    public String getServicePath() {
      return originalRequest.getServicePath();
    }

    @Override
    public String getURL() {
      return originalRequest.getURL();
    }

    @Override
    public String getPathInfo() {
      return originalRequest.getPathInfo();
    }

    @Override
    public String getQueryString() {
      return originalRequest.getQueryString();
    }

    @Override
    public String[] getParameterNames() {
      return originalRequest.getParameterNames();
    }

    @Override
    public String getParameter(String name) {
      if (PARAM_VALUE.equals(name)) {
        return valueParam;
      } else {
        return originalRequest.getParameter(name);
      }
    }

    @Override
    public String[] getParameterValues(String name) {
      return originalRequest.getParameterValues(name);
    }

    @Override
    public String[] getHeaderNames() {
      return originalRequest.getHeaderNames();
    }

    @Override
    public String getHeader(String name) {
      return originalRequest.getHeader(name);
    }

    @Override
    public String[] getHeaderValues(String name) {
      return originalRequest.getHeaderValues(name);
    }

    @Override
    public String getExtensionPath() {
      return originalRequest.getExtensionPath();
    }

    @Override
    public String getContentType() {
      return originalRequest.getContentType();
    }

    @Override
    public Content getContent() {
      return originalRequest.getContent();
    }

    @Override
    public Object parseContent() {
      return originalRequest.parseContent();
    }

    @Override
    public boolean isGuest() {
      return originalRequest.isGuest();
    }

    @Override
    public String getFormat() {
      return originalRequest.getFormat();
    }

    @Override
    public Description.FormatStyle getFormatStyle() {
      return originalRequest.getFormatStyle();
    }

    @Override
    public String getAgent() {
      return originalRequest.getAgent();
    }

    @Override
    public String getJSONCallback() {
      return originalRequest.getJSONCallback();
    }

    @Override
    public boolean forceSuccessStatus() {
      return originalRequest.forceSuccessStatus();
    }

    @Override
    public Runtime getRuntime() {
      return originalRequest.getRuntime();
    }

    private void setValueParam(String value) {
      this.valueParam = value;
    }

  }
}
