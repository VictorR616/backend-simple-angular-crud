FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/backend-simple-angular-crud-0.0.1.jar
COPY ${JAR_FILE} backend-simple-angular-crud.jar
CMD ["java", "-jar", "backend-simple-angular-crud.jar"]
