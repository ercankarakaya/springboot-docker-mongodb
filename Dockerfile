FROM openjdk:17-jdk-slim
ADD target/docker-springboot-mongodb.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]