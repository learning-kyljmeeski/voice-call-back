FROM openjdk:17.0.1
COPY target/voice-call-application-0.0.1-SNAPSHOT.jar server.jar
ENTRYPOINT ["java", "-jar", "/server.jar"]