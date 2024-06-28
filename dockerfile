FROM maven:3.9.6-eclipse-temurin-21-jammy as builder
WORKDIR /usr/src/app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:21-jdk-slim
RUN mkdir jars && cd jars
WORKDIR /jars
COPY --from=builder /usr/src/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
