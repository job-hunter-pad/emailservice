FROM openjdk:15-jdk-alpine
ARG JAR_FILE=target/emailservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} emailservice.jar
ENTRYPOINT ["java","-jar","/authentication.jar"]