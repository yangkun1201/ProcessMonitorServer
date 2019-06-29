# ProcessMonitorServer
## 简介
本项目为基于SpringBoot搭建的后台项目，使用SpringMvc处理Http请求,使用MyBatis操作数据库，以Json格式进行数据交互，为Web前端和Android端提供服务。
包含以下功能：
* 阿里云短信服务
* Face++人脸识别
* 计时数据CRUD
* 图片上传
* Base64图片存储
* 二维码生成，轮讯服务

## 部署方式：
* 使用mvn package命令打包项目
* 将生成的war包拷贝至tomcat的webapps目录下即可
