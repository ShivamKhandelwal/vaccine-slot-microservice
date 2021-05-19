# Start with a base image containing Java runtime (mine java 8)
FROM openjdk:8u212-jdk-slim

# Add Maintainer Info
LABEL maintainer="shivam.khandelwal15@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file (when packaged)
ARG JAR_FILE=target/vaccine-slot-microservice-1.0.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} vaccine-slot-microservice.jar

# Run the jar file 
ENTRYPOINT ["java","-jar","/vaccine-slot-microservice.jar"]
