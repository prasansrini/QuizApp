#!/usr/bin/env bash

rm -rf build/

git clone https://github.com/prasansrini/QuizApp.git build/QuizApp
git clone https://github.com/prasansrini/Kafka-demo.git build/Kafka-demo-app

./build/Kafka-demo-app/build_run.sh --skip-push || exit
./build/QuizApp/build_run.sh --skip-push || exit

docker compose up -d