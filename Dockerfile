# Use the official OpenJDK base image with Alpine Linux
FROM adoptopenjdk:18-jre-hotspot

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/Pets-Palette-0.0.1-SNAPSHOT.jar /app/your-api.jar

# Expose the port that your application will run on
EXPOSE 8080

# Define the default command to run your application
CMD ["java", "-jar", "your-api.jar"]
