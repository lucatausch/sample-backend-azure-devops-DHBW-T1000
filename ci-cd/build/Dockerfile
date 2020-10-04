FROM openjdk:11
COPY sample-backend/target/*.jar /home/usr/src/app.jar
WORKDIR /home/usr/src/
ENTRYPOINT ["java","-jar","app.jar"]