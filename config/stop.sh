#!/bin/bash

CONTAINER_IDS=$(docker ps -q --filter ancestor=task-master:latest)

echo $CONTAINER_IDS | xargs docker stop

