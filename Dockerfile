#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml clean package



## Install OpenJDK-11
#RUN apt-get update && \
#    apt-get install -y openjdk-11-jre-headless && \
#    apt-get clean;
#
##
## Package stage
##
#FROM openjdk:11-jre-slim
FROM adoptopenjdk:11
COPY --from=build /app/target/*.jar onlineexam.jar
CMD ["java","-jar", "-Dspring.profiles.active=docker", "onlineexam.jar"]