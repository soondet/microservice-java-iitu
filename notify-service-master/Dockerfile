FROM openjdk:8
ADD /target/notify-service.jar notify-service.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "notify-service.jar"]