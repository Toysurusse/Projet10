RUN USER docker
FROM tomcat:8
# Take the war and copy to webapps of tomcat
COPY spring-boot-soap/target/*.war /usr/local/tomcat/webapps/
# Added for jenkins demo