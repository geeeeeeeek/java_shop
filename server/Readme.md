# Document of this project
> 学习过程中，遇到问题可以咨询作者：lengqin1024（微信）

### 功能

* 增删改查
* 文件上传
* 数据库配置
* 日志管理
* 权限控制

### 后端部署流程

1. 配置端口 位于application.yml
2. 配置DB_NAME 位于application.yml
3. 配置BASE_LOCATION 位于application.yml
4. 修改logback-spring.xml下的LOG_HOME的value值
5. maven clean -> maven package
6. 将jar包复制到服务器
7. 将upload文件夹复制到服务器
8. 迁移mysql数据库
9. 运行启动jar包命令

### 运行jar命令（或双击start.sh）

title xxxx
java -jar -Xms64m -Xmx128m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=64m xxxxx.jar


### 数据库相关

删除数据库命令：

drop database if exists book;

创建数据库命令：

CREATE DATABASE IF NOT EXISTS book DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

数据库备份命令:

mysqldump -u root -p --databases 数据库名称 > xxx.sql

数据库恢复命令：

source D:\\xxx.sql


### 常见问题

#### 日志路径

修改logback-spring.xml下的LOG_HOME的value值

#### 配置数据库

application.yml中

#### Druid连接池配置

* application.yml中配置druid
* 参考链接：https://blog.csdn.net/nothingavenger/article/details/114119585
* 监控地址：http://localhost:8009/druid/index.html

#### mysql主键id过长

https://blog.csdn.net/qq_46728644/article/details/120772577

#### yml不起作用

需要maven clean一下

#### 注意实体字段最好是String类型

实体字段最好是String类型，mybatis-plus的update的时候，null的不更新

#### 打包步骤

maven clean -> maven package

https://blog.csdn.net/weixin_42822484/article/details/107893586

#### 配置文件上传大小

application.yml中multipart下

#### 静态资源路径配置

https://blog.csdn.net/cylcjsg/article/details/128102776?

#### 跨域配置

见CorsConfig.java





