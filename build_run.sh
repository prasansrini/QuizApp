#!/usr/bin/env bash

mvn clean install -DskipTests || exit
docker build -t quiz-app . || exit
docker tag quiz-app prasansrini29/quiz-app
docker login -u prasansrini29
docker push prasansrini29/quiz-app

# Enable this if Docker compose is not used.
#docker run --name quiz-app-docker -p 8888:8888 quiz-app || exit