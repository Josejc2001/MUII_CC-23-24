FROM eclipse-temurin:17-jdk-alpine

WORKDIR MUII_CC-23-24/backend

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "test"]
