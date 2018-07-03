FROM openjdk:8-jdk-alpine

ENV APP_NAME=kotlin-webapp

WORKDIR /opt

RUN unzip build/distributions/$APP_NAME.zip

WORKDIR /opt/$APP_NAME

CMD["sh","bin/$APP_NAME"]
