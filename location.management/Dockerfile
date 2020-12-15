FROM openjdk:8
ADD /target/location.jar location.jar
EXPOSE 8006
ENTRYPOINT ["java", "-jar", "location.jar"]