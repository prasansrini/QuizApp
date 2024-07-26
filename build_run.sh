#!/usr/bin/env bash

#mvn clean package || exit
docker build -t quiz-app . || exit
docker run -p 8888:8888 quiz-app || exit