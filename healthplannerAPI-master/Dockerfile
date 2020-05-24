FROM openjdk:8-jre-alpine
RUN apk add curl openjdk8 maven
RUN mkdir -p /home/code
COPY . /home/code
WORKDIR /home/code
RUN mvn clean install
EXPOSE 8080
COPY ./target/healthplanner-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]
