FROM tomcat:8.0-alpine
# Take the war and copy to webapps of tomcat
COPY target/*.war /opt/local/tomcat/latest/webapps/
COPY tocmcat-users.xml /usr/local/tomcat/latest/conf/
# Added for jenkins demo