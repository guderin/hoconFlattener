#!/bin/bash

APP_NAME=$(find target -name *jar-with-dependencies.jar)

java -jar ${APP_NAME}
