FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY target/*.jar /app/*.jar
ENTRYPOINT ["java", "-jar", "/app/*.jar"]