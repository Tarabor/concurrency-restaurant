FROM openjdk:8-jdk-alpine
VOLUME /mnt
ADD target/mytest.jar mytest.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","mytest.jar"]