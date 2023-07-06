# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build

# Information around who maintains the image
MAINTAINER jsc.com

# Add the application's jar to the container
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer-0.0.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java", "-jar", "/EurekaServer-0.0.1-SNAPSHOT.jar"]