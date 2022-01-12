FROM openjdk:8-jdk-slim
MAINTAINER 1667834841@qq.com

# 环境变量
ARG  JAR_NAME=oneManager-java.jar
ARG  WORK_PATH=/opt/jar
ENV JAR_NAME JAR_NAME
ENV WORK_PATH WORK_PATH


# 创建jar目录
RUN mkdir ${WORK_PATH}
# 设置工作目录
WORKDIR ${WORK_PATH}

COPY ./target/oneManager-java.jar ${WORK_PATH}/${JAR_NAME}

EXPOSE 8081

CMD java -jar ${WORK_PATH}/${JAR_NAME} --spring.profiles.active=dev

