FROM openjdk:15-jdk-alpine

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} emailservice.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/emailservice.jar"]