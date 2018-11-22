FROM tomcat:8.5.35-jre8
# Take the war and copy to webapps of tomcat
RUN ["rm", "-fr", "/opt/tomcat/latest/webapps/ROOT"]
COPY spring-boot-soap/target/spring-boot-soap-0.0.1-SNAPSHOT.war /opt/tomcat/latest/webapps/
