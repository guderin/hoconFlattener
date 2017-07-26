#!/bin/bash

CONFIG_FILE_NAME=$1
APP_NAME=$(find target -name *jar-with-dependencies.jar)

java -jar ${APP_NAME} ${CONFIG_FILE_NAME}
