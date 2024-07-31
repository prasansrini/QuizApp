#!/usr/bin/env bash

mvn clean install -DskipTests || exit
docker build -t quiz-app . || exit
docker tag quiz-app prasansrini29/quiz-app || exit
docker login -u prasansrini29 || exit
docker push prasansrini29/quiz-app || exit

# Enable this if Docker compose is not used.
#docker run --name quiz-app-docker -p 8888:8888 quiz-app || exit