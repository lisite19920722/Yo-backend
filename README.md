# 大冬重构

大冬带你起飞！

## 项目环境配置

开发机器上需要准备以下环境：

* gradle 2.4（目前只支持2.4）
* JDK 1.8 + （1.8以上）
* Mysql 5.5.0+ （本地安装mysql）
* IDEA

## 开发环境配置

### 1. 导入 gradle 项目到IDEA

### 2. 配置数据库 mysql.properties 和 gralde.properties 文件
* mysql.properties // 放在项目dal目录的resource文件夹中
(dal/src/main/resources/mysql.properties.back文件,直接复制一份去掉.back就可以)

```
# c3p0.X
c3p0.driverClassName=com.mysql.jdbc.Driver
c3p0.url=jdbc:mysql://localhost:3306/nevermore_dev?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8  //改我
c3p0.username=xxx  //改我
c3p0.password=xxx  //改我
c3p0.MaxPoolSize=20
c3p0.MinPoolSize=10

```

* gradle.properties //放在项目根目录下

(根目录下有gradle.properties.back文件，直接复制一份去掉.back)

```
flyway.user=xx  //改我
flyway.password=xx  //改我
flyway.url=jdbc:mysql://localhost:3306/puck

```


### 3. 新建数据库，migration 数据

```
	gradle flywayMigrate -i //项目根目录执行
```


### 4. run APIMain.java

在 **puck-web** 目录的java代码中找到 APIMain.java 跑起来。

当你看到 console 报一下内容时候，项目就已经跑起来了：

```
 Http11NioProtocol: Initializing ProtocolHandler ["http-nio-8080"]
 Http11NioProtocol: Starting ProtocolHandler ["http-nio-8080"]
 NioSelectorPool: Using a shared selector for servlet write/read
 TomcatEmbeddedServletContainer: Tomcat started on port(s): 8080 (http)
 APIMain: Started APIMain in 28.597 seconds (JVM running for 29.326)
```

## 开发注意事项

* [代码规范](https://github.com/404Design/404-blog/blob/master/rules/java-code-style.md)
* [用RAML表达 API 需求](http://blog.guoyiliang.com/2015/04/23/raml-init/)
* 开放封闭原则（尽量扩展，而不是修改）
