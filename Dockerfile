FROM openjdk:8-jdk-slim
MAINTAINER 1667834841@qq.com

# 环境变量
ARG JAR_NAME=oneManager-java.jar
ARG WORK_PATH=/opt/jar
ARG ENV_TYPE=dev
ENV JAR_NAME JAR_NAME
ENV WORK_PATH WORK_PATH
ENV ENV_TYPE ENV_TYPE


RUN mkdir /opt/jar

WORKDIR /opt/jar

COPY ./target/oneManager-java.jar /opt/jar/oneManager-java.jar

EXPOSE 8081

CMD java -jar /opt/jar/oneManager-java.jar --spring.profiles.active=dev

