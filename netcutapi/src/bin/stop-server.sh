#!/bin/bash

# 关闭redis数据库
pid1=$(ps -ef | grep redis-server | grep -v grep | awk '{print $2}')
if [ -n "$pid1" ]; then
  kill -9 $pid1
fi
echo "redis-server is stopped"

# 关闭三个服务
pid2=$(ps -ef | grep netcutApi.jar | grep -v grep | awk '{print $2}')
if [ -n "$pid2" ]; then
  kill -9 $pid2
fi
echo "netcutApi.jar is stopped"

# 关闭nginx
nginx -s stop
