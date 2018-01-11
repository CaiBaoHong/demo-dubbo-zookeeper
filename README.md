# demo-dubbo-zookeeper
SpringBoot整合Dubbo，使用zookeeper做注册中心，使用dubbo-admin做管理后台

`dubbo-iface`定义了远程调用的接口，
`dubbo-provider`提供这些接口的具体实现类，
`dubbo-consumer`可以通过接口调用`dubbo-provider`
`dubbo-provider`和`dubbo-consumer`都必须要在编译时依赖`dubbo-iface`

## 安装zookeeper

官网下载后解压，打开配置文件目录。如：E:\develop\zookeeper\conf

复制zoo_sample.cfg-->zoo.cfg

修改zoo.cfg配置，端口、数据目录等：

~~~
tickTime=2000
dataDir=/var/lib/zookeeper
clientPort=2181
~~~

zookeeper目录（`E:\develop\zookeeper\bin`）加入系统path，方便运行命令。

启动`zookeeper`服务端：`zkServer`
使用`zookeeper`客户端连接到服务端：`zkCli -server 127.0.0.1:2181`

## Tomcat启动dubbo-admin链接到zookeeper

自己到dubbo的Github下载源码，编译一个dubbo-admin的war包。本项目目录下的dubbo-admin有我编译好的。

war包放到tomcat的`\webapps`目录下，执行tomcatd目录下的`\bin\startup.bat`启动tomcat。

首次启动会解压war包。首次启动后，停止tomcat（`\bin\shutdown.bat`），然后找到tomcat下的
`\webapps\dubbo-admin\WEB-INF\dubbo.properties`目录，修改dubbo-admin需要连接到的zookeeper服务端，以及管理后台的帐号密码。


## 测试
启动dubbo-provider
启动dubbo-consumer
访问localhost:8080/dubbo-admin，输入帐号密码，即可登录管理后台
如果可以在`提供者`和`消费者`页面下看到相关的信息，则表明provider和consumer都已经成功在zookeeper注册了。

访问dubbo-consumer提供的rest接口：http://localhost:80125/demo/hello/abcd

