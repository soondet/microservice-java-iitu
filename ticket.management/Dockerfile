FROM openjdk:8
ADD /target/ticket.jar ticket.jar
EXPOSE 8004
ENTRYPOINT ["java", "-jar", "ticket.jar"]