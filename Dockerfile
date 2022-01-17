FROM openjdk:8-jdk-slim
MAINTAINER 1667834841@qq.com

# 环境变量
# 用于接收参数
ARG ENV_TYPE=dev
ENV JAR_NAME=oneManager-java.jar
ENV WORK_PATH=/opt/jar
ENV ENV_TYPE=${ENV_TYPE}


RUN mkdir ${JAR_NAME}

WORKDIR ${JAR_NAME}

COPY ./target/oneManager-java.jar ${JAR_NAME}/${WORK_PATH}

EXPOSE 8081

CMD java -jar ${WORK_PATH}/${JAR_NAME} --spring.profiles.active=${ENV_TYPE}

