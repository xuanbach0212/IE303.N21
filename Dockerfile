FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY ./target/spring-boot-library.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]