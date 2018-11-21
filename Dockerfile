FROM tomcat:8.0-alpine
# Take the war and copy to webapps of tomcat
COPY spring-boot-soap/target/*.war /usr/local/tomcat/webapps/

COPY spring-boot-soap/tocmcat-users.xml /usr/local/tomcat/conf/
# Added for jenkins demo