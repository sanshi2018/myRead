# 常用命令笔记



新安装的Linux安装工具组件 netstat等

```shell
yum install net-tools
```

查看主机目前正在启动的服务IP：Port

```shell
netstat -napt
```

centos7查看网卡信息

```shell
ip a
```

查看防火墙是否开启

```shell
systemctl status firewalld
```

开启防火墙

```shell
systemctl start firewalld  #关闭则start改为stop
```

查看所有开启的端口

```shell
firewall-cmd --list-ports
```

防火墙开启端口访问

```shell
firewall-cmd --zone=public --add-port=80/tcp --permanent

firewall-cmd --reload
```

> 命令含义：  --zone #作用域    --add-port=80/tcp #添加端口，格式为：端口/通讯协议    --permanent #永久生效，没有此参数重启后失效
> 注：开启后需要重启防火墙才生效，【重启命令】：

防火墙关闭端口

```shell
firewall-cmd --zone=public --remove-port=80/tcp --permanent
firewall-cmd --reload
```

