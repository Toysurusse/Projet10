FROM tomcat:8.0-alpine
# Take the war and copy to webapps of tomcat
COPY /var/lib/jenkins/workspace/LibraryWSDev/spring-boot-soap/target/spring-boot-soap-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

COPY spring-boot-soap/tocmcat-users.xml /usr/local/tomcat/conf/
# Added for jenkins demo