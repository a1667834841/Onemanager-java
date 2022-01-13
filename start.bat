@echo off
echo 当前批处理全路径：%~f0

# 删除静态文件目录
rd /s /q src/main/resources/static
rd /s /q src/main/resources/templates

echo '删除静态文件夹成功'


cd src\main\resources\webapp
# 生成静态文件
npm run build-prod --scripts-prepend-node-path=auto  & cd ../../../../ & mvn clean -DskipTests=true package

echo '生成静态文件成功'



