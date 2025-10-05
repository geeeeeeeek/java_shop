# 基于Java的商城网站系统设计与实现

> *一直想做一款管理系统，看了很多优秀的开源项目但是发现没有合适的。于是利用空闲休息时间开始自己写了一套管理系统。现将部分源码开源，如需完整源码，可以联系客服微信购买：Lengqin1024*


### 演示地址

前台地址： http://shop.gitapp.cn

后台地址：http://shop.gitapp.cn/admin

后台管理帐号：

用户名：admin123
密码：admin123

### 功能介绍

平台采用B/S结构，后端采用主流的Springboot框架进行开发，前端采用主流的Vue.js进行开发。

整个平台包括前台和后台两个部分。

- 前台功能包括：首页、商品详情页、订单、用户中心模块。
- 后台功能包括：总览、订单管理、商品管理、分类管理、标签管理、评论管理、用户管理、运营管理、日志管理、系统信息模块。

### 适合人群

大学生、系统设计人员、课程作业

### 视频讲解

 https://www.youtube.com/watch?v=S9IyqpCvqr8


### 代码结构

- server目录是后端代码
- web目录是前端代码

### 部署运行

#### 后端运行步骤

1. 下载JDK 1.8，并配置环境变量

2. 下载本代码后，使用IntelliJ IDEA打开server目录

3. 配置server目录中的application.yml文件，配置BASE_LOCATION、DB_NAME、数据库账号密码

4. 安装mysql 5.7数据库，并创建数据库，创建SQL如下：
```
CREATE DATABASE IF NOT EXISTS java_shop DEFAULT CHARSET utf8 COLLATE utf8_general_ci
```
5. 恢复sql数据。在mysql下依次执行如下命令：

```
mysql> use java_shop;
mysql> source D:/xxx/xxx/xxx.sql;
```

6. 启动后端服务：点击IDEA顶部run按钮


#### 前端运行步骤

1. 安装node 16.14

2. 修改web/src/store下的constansts.ts文件中的BASE_URL，改成你自己后端的地址

3. cmd命令进入web目录下，安装依赖，执行:
```
npm install 
```
4. 运行项目
```
npm run dev
```
5. 在浏览器输入: http://localhost:3000 即可预览


 



### 参考论文
[点击进入](doc/java_shop.docx)


### 视频讲解

https://www.youtube.com/watch?v=S9IyqpCvqr8
 

### 付费咨询

微信：Lengqin1024

 
