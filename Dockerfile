FROM maven:latest AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src
WORKDIR /build
RUN mvn clean install

FROM openjdk:8-jre-alpine
WORKDIR /api
COPY --from=MAVEN_BUILD /build/target/boavista-0.0.1-SNAPSHOT.jar /api

ENTRYPOINT ["java", "-jar", "boavista-0.0.1-SNAPSHOT.jar"]

