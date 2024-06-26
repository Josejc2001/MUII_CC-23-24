FROM eclipse-temurin:17-jdk-alpine

WORKDIR /backend

COPY ../backend/.mvn/ .mvn
COPY ../backend/mvnw ../backend/pom.xml ./

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY ../backend/src ./src

CMD ["./mvnw", "test"]
