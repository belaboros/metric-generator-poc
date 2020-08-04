FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/metric-generator-poc-0.0.1-SNAPSHOT.jar  app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]