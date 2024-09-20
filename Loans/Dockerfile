# Start with a base image containing Java Runtime 17
FROM openjdk:17-jdk-slim

# Maintainer of the image
MAINTAINER andymartinez1.com

# Adding application jar to image
COPY target/loans-0.0.1-SNAPSHOT.jar loans-0.0.1-SNAPSHOT.jar

# Executing the application
ENTRYPOINT ["java", "-jar", "loans-0.0.1-SNAPSHOT.jar"]


