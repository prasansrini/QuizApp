#!/usr/bin/env bash

if [ "$1" == "" ]
    then
    echo "Usage: './build_run.sh <DOCKER_HUB_PASSWORD>' to build and push image to Docker hub."
    echo "[OR]"
    echo "Usage: './build_run.sh --host' to run locally."
    echo "[OR]"
    echo "Usage: './build_run.sh --dockerize' to run locally as a container."
    exit
fi

mvn clean install -DskipTests || exit

if [ "$1" == "--dockerize" ]
    then
      docker build -t quiz-app . || exit
      docker run -p 8888:8888 quiz-app
      echo "Running quiz-app"
      exit
elif [ "$1" == "--host" ]
    then
      java -Dspring.profiles.active=local -jar target/OUTPUT.jar
      exit
else
  docker build -t quiz-app . || exit
fi

docker tag quiz-app prasansrini29/quiz-app || exit
docker login -u prasansrini29 -p $1 || exit
docker push prasansrini29/quiz-app || exit

# Enable this if Docker compose is not used.
#docker run --name quiz-app-docker -p 8888:8888 quiz-app || exit