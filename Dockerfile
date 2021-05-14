#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM amazoncorretto:11-alpine
RUN apk add --no-cache bash
RUN wget -q https://github.com/vishnubob/wait-for-it/raw/master/wait-for-it.sh -O /usr/bin/wait-for-it && \
    chmod +x /usr/bin/wait-for-it
COPY --from=build /app/target/*.jar onlineexam.jar
ENTRYPOINT /usr/bin/wait-for-it mysql_db:3306 -t 120 ; java -jar -Dspring.profiles.active=docker onlineexam.jar


