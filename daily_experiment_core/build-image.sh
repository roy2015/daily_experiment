#!/bin/bash

docker rmi -f daily_experiment_core:v1.0.0
docker build -f Dockerfile.x86_64 -t daily_experiment_core:v1.0.0 --build-arg JAVA_OPTS="-Xms6144m -Xmx6144m -Xmn3g -XX:MetaspaceSize=515m"  .