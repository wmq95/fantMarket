FROM java:alpine
VOLUME /tmp
ADD zuul-service-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]