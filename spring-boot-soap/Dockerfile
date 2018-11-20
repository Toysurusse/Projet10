RUN USER docker
FROM java:8
EXPOSE 8085
ADD spring-boot-soap/target/spring-boot-soap-0.0.1-SNAPSHOT.war springspring-boot-soap-0.0.1-SNAPSHOT.war
ENTRYPOINT {"java","-jar","spring-boot-soap-0.0.1-SNAPSHOT.war"}
