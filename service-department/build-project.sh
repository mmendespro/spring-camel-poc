#!/bin/bash

# build the app
mvn clean spring-boot:run
# stop container
# docker stop empregado-service-jvm
# remove container
# docker rm empregado-service-jvm
# remove container image
# docker rmi spring/empregado-service-jvm:latest
# build container image
# docker build -f Dockerfile.jvm -t spring/empregado-service-jvm .
# run container
# docker run -id --network=trace-net --name empregado-service-jvm -p 8082:8082 spring/empregado-service-jvm