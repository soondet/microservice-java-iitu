FROM openjdk:8
ADD /target/passenger.jar passenger.jar
EXPOSE 8003
ENTRYPOINT ["java", "-jar", "passenger.jar"]