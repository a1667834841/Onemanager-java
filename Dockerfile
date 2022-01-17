FROM openjdk:8-jdk-slim
MAINTAINER 1667834841@qq.com

# 环境变量
ENV JAR_NAME JoneManager-java.jar
ENV WORK_PATH /opt/jar
ENV ENV_TYPE dev


RUN mkdir ${WORK_PATH}

WORKDIR ${WORK_PATH}

COPY ./target/oneManager-java.jar ${WORK_PATH}/${JAR_NAME}

EXPOSE 8081

CMD java -jar ${WORK_PATH}/${JAR_NAME} --spring.profiles.active=${ENV_TYPE}

