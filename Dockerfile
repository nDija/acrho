FROM openjdk:21
WORKDIR /acrho-rest
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar app.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]