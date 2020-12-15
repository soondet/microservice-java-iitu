FROM openjdk:8
ADD /target/driver.jar driver.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar", "driver.jar"]