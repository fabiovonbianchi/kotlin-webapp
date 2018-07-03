FROM openjdk:8-jdk-alpine

ENV APP_NAME=kotlin-webapp

COPY build/distributions/$APP_NAME.zip /tmp

WORKDIR /opt

RUN unzip /tmp/$APP_NAME.zip

WORKDIR /opt/$APP_NAME

CMD ["sh","bin/$APP_NAME"]
