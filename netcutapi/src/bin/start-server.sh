#!/bin/bash

base_dir=$(
  cd $(dirname $0)/../
  pwd
)

# 如果没有log目录，创建log目录
if [ ! -d "$base_dir/log" ]; then
  mkdir "$base_dir/log"
fi

# 如果有进程在运行，先杀掉
pid=$(ps -ef | grep netcutApi.jar | grep -v grep | awk '{print $2}')
if [ -n "$pid" ]; then
  kill -9 $pid
  echo "netcutApi.jar is killed"
fi

# 启动redis数据库
nohup redis-server >$base_dir/log/redis.log 2>&1 &
echo "redis-server is started"

# 启动三个服务
nohup java -jar $base_dir/netcutApi.jar --spring.application.name=nca1 --server.port=8081 >$base_dir/log/nca1.log 2>&1 &
nohup java -jar $base_dir/netcutApi.jar --spring.application.name=nca2 --server.port=8082 >$base_dir/log/nca2.log 2>&1 &
nohup java -jar $base_dir/netcutApi.jar --spring.application.name=nca3 --server.port=8083 >$base_dir/log/nca3.log 2>&1 &
echo "netcutApi.jar is started"
