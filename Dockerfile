FROM openjdk:8-jdk-alpine

ENV APP_NAME=kotlin-webapp

COPY build/distributions/$APP_NAME.zip /tmp/

WORKDIR /

RUN unzip /tmp/$APP_NAME

#CMD["./kotlin-webapp/bin/app/kotlin-webapp"]

