FROM openjdk:13
RUN mkdir app
ARG JAR_FILE
WORKDIR /app
ADD target/integracao-0.0.1-SNAPSHOT.jar app/integracao-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app/integracao-0.0.1-SNAPSHOT.jar"]
