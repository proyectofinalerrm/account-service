FROM openjdk:11-jdk-slim
COPY ./target/account-service-0.0.1-SNAPSHOT.jar ./
EXPOSE 8095
ENTRYPOINT ["java", "-jar","account-service-0.0.1-SNAPSHOT.jar"]