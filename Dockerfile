FROM ubuntu:14.04

RUN apt-get -yqq update
RUN apt-get -yqq install tomcat8 default-jdk
RUN apt-get -yqq install tomcat8-admin

ENV CATALINA_HOME /usr/share/tomcat8
ENV CATALINA_BASE /var/lib/tomcat8
ENV CATALINA_PID /var/run/tomcat8.pid
ENV CATALINA_SH /usr/share/tomcat8/bin/catalina.sh
ENV CATALINA_TMPDIR /tmp/tomcat8-tomcat8-tmp

RUN mkdir -p $CATALINA_TMPDIR

COPY spring-boot-soap/target/spring-boot-soap-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

ADD tomcat-users.xml /etc/tomcat8/tomcat-users.xml

VOLUME [ "/var/lib/tomcat8/webapps/" ]

EXPOSE 8081

CMD [ "/usr/share/tomcat8/bin/catalina.sh", "run" ]