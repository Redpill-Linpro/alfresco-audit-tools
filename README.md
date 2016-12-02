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


License
-------

This application is licensed under the LGPLv3 License. See the [LICENSE file](LICENSE) for details.

Authors
-------

Marcus Svartmark - Redpill Linpro AB
