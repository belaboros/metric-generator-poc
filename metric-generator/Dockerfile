#FROM ubuntu
#COPY target/*.jar /app/
#CMD mvn spring-boot:run



FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY target/metricgenerator-0.0.1-SNAPSHOT.jar app/app.jar

#COPY target/metricgenerator-0.0.1-SNAPSHOT.jar app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]