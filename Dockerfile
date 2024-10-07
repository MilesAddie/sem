# Build Stage
FROM maven:3.8.1-openjdk-11 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

#run stage
FROM openjdk:11-jdk-slim
WORKDIR /app
COPY /target/seMethods-1.0-SNAPSHOT-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]