FROM openjdk:8-jre-alpine
RUN apk add curl jdk mvn
RUN mkdir -p /home/code
COPY . /home/code
WORKDIR /home/code
RUN mvn clean install
ENV APP_FILE healthplanner-0.0.1-SNAPSHOT.jar
ENV APP_HOME /usr/app
EXPOSE 8080
COPY target/${APP_FILE} ${APP_HOME}/
WORKDIR ${APP_HOME}
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
