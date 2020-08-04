#!/bin/bash

CONTAINERS=$(docker container ls --all | grep metric-generator | cut -f 1 -d " ")

if [ ! -z "${CONTAINERS}" ]; then
    echo "Stopping containers: \"${CONTAINERS}\""
    docker stop ${CONTAINERS}

    echo "Removing containers: ${CONTAINERS}"
    docker rm ${CONTAINERS} --force
else 
    echo "There are no containers for metric-generator"
fi
