FROM tomcat:8.0
# Take the war and copy to webapps of tomcat
COPY target/*.war /usr/local/tomcat/webapps/
COPY tocmcat-user.xml /usr/local/tomcat/conf/tomcat-users.xml
# Added for jenkins demo