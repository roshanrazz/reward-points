FROM openjdk:17

EXPOSE 8080

ADD ./target/*.jar reward-points.jar

ENTRYPOINT [ "java","-jar","reward-points.jar"]
