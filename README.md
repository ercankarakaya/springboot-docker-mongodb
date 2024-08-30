# Spring Boot – Docker – MongoDB Example Project

This project is a simple example of integrating Spring Boot with Docker and MongoDB. The following instructions will guide you through setting up the project and running it in a Dockerized environment.

## Prerequisites:

#### Java 17
#### Spring Boot 3
#### Docker installed on your machine
#### You should enable Lombok extension in your IDE.

## Set Up MongoDB in Docker:
- Pull the MongoDB Docker Image:
```bash
docker pull mongo:latest
```
- Verify the Image:
```bash
docker images
```
- Run MongoDB Container:
```bash
docker run -d -p 27017:27017 --name mymongodb mongo:latest
```
