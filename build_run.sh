#!/usr/bin/env bash

mvn clean package || exit
docker build -t quiz-app . || exit

# Enable this if Docker compose is not used.
#docker run --name quiz-app-docker -p 8888:8888 quiz-app || exit