FROM openjdk:8
ADD /target/service-discovery.jar service-discovery.jar
EXPOSE 8003
ENTRYPOINT ["java", "-jar", "service-discovery.jar"]