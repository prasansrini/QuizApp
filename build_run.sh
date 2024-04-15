#!/usr/bin/env bash

mvn clean package
java -jar target/OUTPUT.jar
