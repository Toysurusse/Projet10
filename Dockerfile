FROM tomcat:8.0-alpine
# Take the war and copy to webapps of tomcat
RUN mkdir -p /usr/local/tomcat/conf
COPY librarywsDev/spring-boot-soap/tocmcat-users.xml /usr/local/tomcat/conf/
COPY spring-boot-soap/target/*.war /usr/local/tomcat/webapps/
# Added for jenkins demo