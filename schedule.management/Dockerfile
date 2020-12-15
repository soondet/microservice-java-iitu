FROM openjdk:8
ADD /target/schedule.jar schedule.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "schedule.jar"]