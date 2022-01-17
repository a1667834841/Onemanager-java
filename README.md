
<div align=center>
<img src="https://z3.ax1x.com/2021/10/25/5hztzR.png" width="200" height="200">
</div>



## OneManager-Java

###  About

**OneManager-java**是基于[OneManager-php](https://github.com/qkqpttgf/OneManager-php) 的原型上二次开发的一款基于**SpringBoot**的Java网盘程序

### start

#### windows
执行`start.bat`文件
再在运行idea里运行，或者 在当前目录执行`java -jar  oneManager-java.jar --spring.profiles.active=prod`

#### docker
```shell
docker run -p 8081:8081 --rm -d --name onemanager-java ggball/onemanager-java:1.0
```

用浏览器打开 `http://localhost:8081/`

### demo
[演示站](https://ggball.top/oneManagerjava#/)



### TODO

#### 2021-12
- [X] 获取onedrive token (secreteId->code->token)
- [X] 使用java 调用onedrive接口  获取文件目录信息，获取文件内容
- [X] 使用vue 展示网盘目录信息，文件内容
- [X] 增加缩略图模式
![img.png](https://gitee.com/zxqzhuzhu/imgs/raw/master/picGo/image-20211226011921711.png)
  
#### 2022-01
- [ ] ~~分页列表~~
- [ ] 定时任务 将指定目录网盘数据，交给es,es并创建索引 
- [X] 文件的上传，删除
- [ ] md文件的修改