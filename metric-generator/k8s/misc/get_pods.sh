#!/bin/bash

#kubectl get pods | grep metric-generator
#PODS=$(kubectl get pods -o custom-columns=POD_NAME:.metadata.name | grep metric-generator)
PODS=$(kubectl get pods -o wide  | grep metric-generator)
echo "${PODS}" | sort | tee metric-generator.pods.txt
