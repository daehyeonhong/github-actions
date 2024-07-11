FROM amazoncorretto:21-alpine
COPY build/libs/*.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]