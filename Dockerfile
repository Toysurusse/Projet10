FROM tomcat:8.0-alpine
# Take the war and copy to webapps of tomcat
RUN ["rm", "-fr", "/usr/local/tomcat/webapps/ROOT"]
COPY ./target/your-webapp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
# Added for jenkins demo