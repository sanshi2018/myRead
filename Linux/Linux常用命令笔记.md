# 常用命令笔记



## 新安装的Linux安装工具组件 netstat等

```shell
yum install net-tools
```

## 查看主机目前正在启动的服务IP：Port

```shell
netstat -napt
```

## centos7查看网卡信息

```shell
ip a
```

## 查看防火墙是否开启

```shell
systemctl status firewalld
```

## 开启防火墙

```shell
systemctl start firewalld  #关闭则start改为stop
```

## 查看所有开启的端口

```shell
firewall-cmd --list-ports
```

## 防火墙开启端口访问

```shell
firewall-cmd --zone=public --add-port=80/tcp --permanent

firewall-cmd --reload
```

> 命令含义：  --zone #作用域    --add-port=80/tcp #添加端口，格式为：端口/通讯协议    --permanent #永久生效，没有此参数重启后失效
> 注：开启后需要重启防火墙才生效，【重启命令】：

## 防火墙关闭端口

```shell
firewall-cmd --zone=public --remove-port=80/tcp --permanent
firewall-cmd --reload
```

## 安装java环境

yum方式下载安装
1、查找java相关的列表

```shell
yum -y list java*
```

或者

```shell
yum search jdk
```

2、安装jdk

```shell
yum install java-1.8.0-openjdk.x86_64
```

3、完成安装后验证

```shell
java -version
```

4、通过yum安装的默认路径为：`/usr/lib/jvm`

5、将jdk的安装路径加入到JAVA_HOME

```shell
sudo vim /etc/profile
```

在文件最后加入：

```shell
#set java environment
JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk-1.8.0.352.b08-2.el7_9.x86_64 # 这个值以实际为准，具体查看/usr/lib/jvm/目录下自己的jre
PATH=$PATH:$JAVA_HOME/bin
CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export JAVA_HOME CLASSPATH PATH
```

修改/etc/profile之后让其生效

`source /etc/profile` （注意 source 之后应有一个空格）

## 安装wget命令

```shell
sudo yum -y install wget
```

## 安装zookeeper

> ***前提：由于zookeeper是使用java语言开发的，所以，在安装zookeeper之前务必先在本机安装配置好java环境！***

```shell
wget https://archive.apache.org/dist/zookeeper/zookeeper-3.4.9/zookeeper-3.4.9.tar.gz
```

解压

```shell
tar -zxvf zookeeper-3.4.9.tar.gz
```

```shell
[sanshi@localhost myproject]$ ll
drwxr-xr-x. 10 sanshi  sanshi      4096 Aug 23  2016 zookeeper-3.4.9
-rw-rw-r--.  1 sanshi  sanshi  22724574 Sep  3  2016 zookeeper-3.4.9.tar.gz
```

3，配置conf文件

```shell
[sanshi@localhost zookeeper-3.4.9]$ ls
bin        CHANGES.txt  contrib     docs             ivy.xml  LICENSE.txt  README_packaging.txt  recipes  zookeeper-3.4.9.jar      zookeeper-3.4.9.jar.md5
build.xml  conf         dist-maven  ivysettings.xml  lib      NOTICE.txt   README.txt            src      zookeeper-3.4.9.jar.asc  zookeeper-3.4.9.jar.sha1
[sanshi@localhost zookeeper-3.4.9]$ cd conf/
[sanshi@localhost conf]$ ls
configuration.xsl  log4j.properties  zoo_sample.cfg
[sanshi@localhost conf]$ cp zoo_sample.cfg zoo.cfg
[sanshi@localhost conf]$ vim zoo.cfg 
```

> 可以看到这里有个zoookeeper给我们的一个样例配置文件：zoo_sample.cfg，我们在配置我们自己的zk时，需要做的就是将这个文件复制一份，并命名为：zoo.cfg，然后在zoo.cfg中修改自己的配置即可。

zoo.cfg的相关配置项其实并不多，这边各个配置项的详细说明如下：

```shell
# zookeeper内部的基本单位，单位是毫秒，这个表示一个tickTime为2000毫秒，在zookeeper的其他配置中，都是基于tickTime来做换算的
tickTime=2000

#集群中的follower服务器(F)与leader服务器(L)之间 初始连接 时能容忍的最多心跳数（tickTime的数量）。
initLimit=10

#syncLimit：集群中的follower服务器(F)与leader服务器(L)之间 请求和应答 之间能容忍的最多心跳数（tickTime的数量）
syncLimit=5

# 数据存放文件夹，zookeeper运行过程中有两个数据需要存储，一个是快照数据（持久化数据）另一个是事务日志
dataDir=/tmp/zookeeper

# 客户端访问端口
clientPort=2181

```

4，配置环境变量

```shell
sudo vim /etc/profile

# 文件末尾追加zookeeper相关配置
export ZOOKEEPER_HOME=/home/sanshi/myproject/zookeeper-3.4.9 #这里设置解压的zk目录
export PATH=$ZOOKEEPER_HOME/bin:$PATH
export PATH
```

配置生效

```shell
[sanshi@localhost zookeeper-3.4.9]$ source /etc/profile
```

5，启动服务

```shell
[sanshi@localhost ~]$ zkServer.sh start
ZooKeeper JMX enabled by default
Using config: /home/sanshi/myproject/zookeeper-3.4.9/bin/../conf/zoo.cfg
Starting zookeeper ... STARTED
```

如果启动失败可以使用,使用这个命令启动[zookeeper](https://so.csdn.net/so/search?q=zookeeper&spm=1001.2101.3001.7020)可以查看错误信息

```shell
zkServer.sh start-foreground
```

查看启动状态

```shell
[sanshi@localhost ~]$ zkServer.sh status
ZooKeeper JMX enabled by default
Using config: /home/sanshi/myproject/zookeeper-3.4.9/bin/../conf/zoo.cfg
Mode: standalone
```

6，客户端连接

```shell
[sanshi@localhost ~]$ zkCli.sh
Connecting to localhost:2181
2022-12-26 22:32:17,137 [myid:] - INFO  [main:Environment@100] - Client environment:zookeeper.version=3.4.9-1757313, built on 08/23/2016 06:50 GMT
2022-12-26 22:32:17,139 [myid:] - INFO  [main:Environment@100] - Client environment:host.name=localhost
2022-12-26 22:32:17,139 [myid:] - INFO  [main:Environment@100] - Client environment:java.version=1.8.0_352
2022-12-26 22:32:17,140 [myid:] - INFO  [main:Environment@100] - Client environment:java.vendor=Red Hat, Inc.
2022-12-26 22:32:17,140 [myid:] - INFO  [main:Environment@100] - Client environment:java.home=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.352.b08-2.el7_9.x86_64/jre
2022-12-26 22:32:17,140 [myid:] - INFO  [main:Environment@100] - Client environment:java.class.path=/home/sanshi/myproject/zookeeper-3.4.9/bin/../build/classes:/home/sanshi/myproject/zookeeper-3.4.9/bin/../build/lib/*.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../lib/slf4j-log4j12-1.6.1.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../lib/slf4j-api-1.6.1.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../lib/netty-3.10.5.Final.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../lib/log4j-1.2.16.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../lib/jline-0.9.94.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../zookeeper-3.4.9.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../src/java/lib/*.jar:/home/sanshi/myproject/zookeeper-3.4.9/bin/../conf:.:/usr/lib/jvm/jre-1.8.0-openjdk-1.8.0.352.b08-2.el7_9.x86_64/lib/dt.jar:/usr/lib/jvm/jre-1.8.0-openjdk-1.8.0.352.b08-2.el7_9.x86_64/lib/tools.jar
2022-12-26 22:32:17,140 [myid:] - INFO  [main:Environment@100] - Client environment:java.library.path=/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:java.io.tmpdir=/tmp
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:java.compiler=<NA>
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:os.name=Linux
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:os.arch=amd64
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:os.version=3.10.0-1160.el7.x86_64
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:user.name=sanshi
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:user.home=/home/sanshi
2022-12-26 22:32:17,141 [myid:] - INFO  [main:Environment@100] - Client environment:user.dir=/home/sanshi
2022-12-26 22:32:17,141 [myid:] - INFO  [main:ZooKeeper@438] - Initiating client connection, connectString=localhost:2181 sessionTimeout=30000 watcher=org.apache.zookeeper.ZooKeeperMain$MyWatcher@5ce65a89
Welcome to ZooKeeper!
2022-12-26 22:32:17,155 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1032] - Opening socket connection to server localhost/0:0:0:0:0:0:0:1:2181. Will not attempt to authenticate using SASL (unknown error)
JLine support is enabled
2022-12-26 22:32:17,226 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@876] - Socket connection established to localhost/0:0:0:0:0:0:0:1:2181, initiating session
2022-12-26 22:32:17,245 [myid:] - INFO  [main-SendThread(localhost:2181):ClientCnxn$SendThread@1299] - Session establishment complete on server localhost/0:0:0:0:0:0:0:1:2181, sessionid = 0x185519f7e850000, negotiated timeout = 30000

WATCHER::

WatchedEvent state:SyncConnected type:None path:null
```

7.开启对外端口

