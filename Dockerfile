FROM openjdk:11
ADD target/microservices-input.jar microservices-input.jar
EXPOSE 6969
ENTRYPOINT ["java","-jar","microservices-input.jar"]

