FROM openjdk:21
EXPOSE 8080
ADD /target/Hello-Events.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]