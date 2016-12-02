Alfresco Audit Tools
=============================================

This module is sponsored by:
* Redpill Linpro AB - http://www.redpill-linpro.com.
* Alingsås Kommun - http://www.alingsas.se

Description
-----------
This project contains some tools to make review of audit records easier

Structure
------------

The project consists of a repository module packaged as jar.

Building & Installation
------------
The build produces a jar file. Attach it to your own maven project using dependencies.

Repository dependency:

```xml
<dependency>
    <groupId>org.redpill-linpro.alfresco.audit-tools</groupId>
    <artifactId>alfresco-audit-tools-repo</artifactId>
    <version>1.0.0</version>
</dependency>
```

Maven repository:
```xml
<repository>
  <id>redpill-public</id>
  <url>http://maven.redpill-linpro.com/nexus/content/groups/public</url>
</repository>
```

The jar files are also downloadable from: https://maven.redpill-linpro.com/nexus/index.html#nexus-search;quick~alfresco-audit-tools


Usage
-----
Use this tool to query the repository for the audit data of a node based on its node ref. This tool will translate the node ref to a valid audit node path. Therefore the syntax is identical to a regular path query with the difference being the value parameter which now should contain a node ref instead of a path.

Example:

The standard way of doing path audit queries:

http://localhost:8080/alfresco/service/api/audit/nodequery/alfresco-access/alfresco-access/transaction/path?verbose=true&forward=false&value=/app:company_home/...

How you can do an audit query based on node ref with this module:
http://localhost:8080/alfresco/service/rl/audit/nodequery/alfresco-access/alfresco-access/transaction/path?verbose=true&forward=false&value=workspace://SpacesStore/d77a6aa1-bac8-42e4-8df8-2faf1a085622


License
-------

This application is licensed under the LGPLv3 License. See the [LICENSE file](LICENSE) for details.

Authors
-------

Marcus Svartmark - Redpill Linpro AB
