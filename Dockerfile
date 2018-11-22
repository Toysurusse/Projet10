FROM tomcat:8.5.35-jre8
# Take the war and copy to webapps of tomcat
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY spring-boot-soap/target/spring-boot-soap-0.0.1-SNAPSHOT.war /opt/local/tomcat/latest/webapps/
