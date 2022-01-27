FROM adoptopenjdk/openjdk11:debian-jre
RUN groupadd app && useradd -g app app
USER app:app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]