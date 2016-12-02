#!/bin/bash
mvn clean package
cp repo/target/alfresco-audit-tools-repo-1.0.0-SNAPSHOT.jar /opt/alfresco/enterprise/5.0.3/alingsas/tomcat-repo/webapps/alfresco/WEB-INF/lib/
#cp share/target/alfresco-system-usage-statistics-share-1.0.0-SNAPSHOT.jar /opt/alfresco/enterprise/5.0.3/alingsas/tomcat-share/webapps/share/WEB-INF/lib/
