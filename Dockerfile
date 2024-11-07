FROM tomcat:11.0.0

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/spring-app1.war /usr/local/tomcat/webapps/

EXPOSE 8080