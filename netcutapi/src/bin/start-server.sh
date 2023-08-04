#!/bin/bash

# 如果没有log目录，创建log目录
if [ ! -d "../log" ]; then
  mkdir ../log
fi

# 如果有进程在运行，先杀掉
pid1=$(ps -ef | grep netcutApi.jar | grep -v grep | awk '{print $2}')
if [ -n "$pid1" ]; then
  kill -9 $pid1
fi

# 启动redis数据库
nohup redis-server >../log/redis.log 2>&1 &
echo "redis-server is started"

# 启动三个服务
nohup java -jar ../netcutApi.jar --spring.application.name=nca1 --server.port=8081 >../log/nca1.log 2>&1 &
nohup java -jar ../netcutApi.jar --spring.application.name=nca2 --server.port=8082 >../log/nca2.log 2>&1 &
nohup java -jar ../netcutApi.jar --spring.application.name=nca3 --server.port=8083 >../log/nca3.log 2>&1 &
echo "netcutApi.jar is started"
