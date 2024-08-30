# Spring Boot Docker MongoDB Example Project

This project is a simple example of integrating Spring Boot with Docker and MongoDB. The following instructions will guide you through setting up the project and running it in a Dockerized environment.

## Prerequisites:

   - Java 17
   - Spring Boot 3
   - Docker installed on your machine
   > [!NOTE]
   >You should enable Lombok extension in your IDE.

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
##### &nbsp; `docker run` : Command to start a Docker container.
##### &nbsp; `-d` (detached mode):  Runs the container in the background.
##### &nbsp; `-p 27017:27017` : Maps port 27017 on your local machine to port 27017 in the container, allowing access to MongoDB at localhost:27017.
##### &nbsp; `--name mymongodb` : Assigns a name mymongodb to the container.
##### &nbsp; `mongo:latest` : Uses the latest version of the MongoDB image from Docker Hub.

## Access MongoDB CLI:
- Connect to the MongoDB container:
```bash
docker exec -it mymongodb mongosh
```
- Use MongoDB commands:
> ##### `show dbs` : List all databases
> ##### `use myDatabase` : Connect to a specific database
> ##### `show collections` : List collections in the database
> ##### `db.myCollection.find().pretty()` : Retrieve all documents in a collection

## Dockerize Spring Boot Application:
```bash
docker build -t docker-springboot-mongodb:1.0 .
```
##### &nbsp; `docker build` : Command to build a Docker image.
##### &nbsp; `-t docker-springboot-mongodb:1.0` : Tags the image with the name docker-springboot-mongodb and version 1.0.
##### &nbsp; `.` : Refers to the current directory where the Dockerfile is located.

##  Run Spring boot Docker image and link that container to mongo container:
```bash
docker run -p 8080:8080 --name docker-springboot-mongodb --link mymongodb:mongo -d docker-springboot-mongodb:1.0
```
##### &nbsp; `-p 8080:8080` : Maps port 8080 on your local machine to port 8080 in the container.
##### &nbsp; `--name docker-springboot-mongodb` : Names the container docker-springboot-mongodb.
##### &nbsp; `--link mymongodb:mongo` : Links the mymongodb container to the Spring Boot container, allowing the application to connect to MongoDB using the hostname mongo.
##### &nbsp; `docker-springboot-mongodb:1.0` : Specifies the image to use.

## To check the logs of spring boot image and docker running containers :
```bash
docker ps
docker logs docker-springboot-mongodb
```
## Using Docker Compose
- To stop and remove a running container:
```bash
docker rm -f docker-springboot-mongodb
```
- If you prefer using Docker Compose, navigate to the directory containing the **docker-compose.yml** file and run:
```bash
docker-springboot-mongodb/src/main/resources > docker-compose up
```
> [!NOTE]
> The **docker-compose.yml** file is located in the **resources** folder of the project.





