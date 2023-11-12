FROM maven:3.9.5 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/quiz-0.0.1-SNAPSHOT.jar quiz.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quiz.jar"]