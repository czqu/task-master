#!/bin/bash
. stop.sh || true

sleep 10

docker rmi task-master:latest

