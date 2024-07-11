# backend/ Dockerfile
FROM openjdk:11-jre-slim
WORKDIR /app
COPY ./target/back-end-0.0.1-SNAPSHOT.jar /app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "application.jar"]
