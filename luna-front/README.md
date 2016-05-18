# luna
大冬重构

```
├── web-project     // Web 前端项目目录
│    ├── gulp           // 自动化构建的逻辑模块
│    ├── dist           // 构建之后的源码目录
│    └── src            // 源码目录

```


## 国际化方案

Web 端版本直接支持国际化方案，具体配置都在 `web-project/src/app/i18n` 目录中，项目中界面内有基本示例。可以实现通过纯 Web 前端实时切换语言，无需服务器切换。

## 使用方式

如果没有使用过，并不了解 LeanCloud 或 LeanEngine，先到[官网](http://leancloud.cn)中了解。

首先确认本机已经安装 [Node.js](http://nodejs.org/) 运行环境和 [LeanCloud 命令行工具](https://leancloud.cn/docs/cloud_code_commandline.html)，之后按照以下方式开始您的开发：

### 依赖安装

* 系统依赖 nodejs 环境为 0.12.x 版本，如果启动遇到错误，请首先确保 nodejs 版本
* 首先 clone 这个代码库到本地目录中
```
$ git clone git@github.com:leancloud/LeanEngine-Full-Stack.git
$ cd LeanEngine-Full-Stack
```

安装服务端环境依赖

* 在 `puck-front 目录`中执行
```
$ npm install
```
安装 Web 端构建依赖

* 在 `puck-front 目录`中执行
```
$ bower install
```
安装 Web 端基础库

### 调试

* 在 puck-front 目录中执行
```
$ gulp serve
```
运行 web 端环境，通过 `http://localhost:9000` 可以调试

* 开发时需要同时运行这两个任务（开两个 terminal），就可以同时调试 Server 与 Web

### 部署

首先请确保项目已经配置[通过 GitHub 部署](https://leancloud.cn/docs/leanengine_guide-node.html#使用_GitHub_托管源码)。

* 在 `puck-front 目录`中执行
```
$ gulp build
```
构建系统会自动打包，自动压缩合并代码，发布到 public 目录中

* 将最新代码，连同 public 目录中的代码，全部提交到对应的 GitHub 仓库中

* 在根目录执行
