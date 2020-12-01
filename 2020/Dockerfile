# Build
FROM maven:3.6.3-openjdk-8 AS build

COPY . /usr/src/app

RUN mvn -f /usr/src/app/pom.xml clean package


# Package
FROM openjdk:8u212-jre-alpine

WORKDIR /data
COPY --from=build /usr/src/app/target/aoc2020-*-jar-with-dependencies.jar /aoc2020.jar

CMD ["java", "-jar", "/aoc2020.jar", "--all"]
