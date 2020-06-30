FROM openjdk:8
EXPOSE 8081
ADD target/spring-boot-rest-app-0.0.1-SNAPSHOT.jar spring-boot-rest-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-rest-app-0.0.1-SNAPSHOT.jar"]
