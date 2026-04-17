FROM tomcat:10-jdk17

LABEL maintainer="MaryOkpala"
LABEL project="crucible"
LABEL description="Project Crucible - Production CI/CD Pipeline Application"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY app/target/crucible-app.war /usr/local/tomcat/webapps/ROOT.war

RUN sed -i 's/port="8080"/port="8080" maxThreads="200" minSpareThreads="10"/' \
    /usr/local/tomcat/conf/server.xml

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

CMD ["catalina.sh", "run"]
