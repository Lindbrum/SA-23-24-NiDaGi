FROM maven:3.9.2-eclipse-temurin-17-alpine

WORKDIR /attraction-reservation-microservice
COPY  . .

RUN mvn clean install -Dmaven.test.skip=true
CMD mvn spring-boot:run
