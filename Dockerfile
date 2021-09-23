FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} cadastro-api.jar
ENTRYPOINT ["java","-jar","/cadastro-api.jar"]