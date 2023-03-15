#!/bin/bash

docker run -p 8080:8080 --env-file ./.my.env task-master:latest  > /var/log/task-master.log 2>&1
