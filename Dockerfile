# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM openjdk:17.0.1-jdk-slim-bullseye
COPY --from=build /target/HealthHub.jar HealthHub.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "HealthHub.jar"]








#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests

#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/HealthHub.jar HealthHub.jar
#EXPOSE 8080
#ENTRYPOINT [ "java","-jar","HealthHub.jar" ]
