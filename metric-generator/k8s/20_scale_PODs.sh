#!/bin/bash
# Change the number of PODs (replicas) of metric-generator


REPLICA_COUNT=${1:-1}
echo "Setting the number of PODs (replicas) to ${REPLICA_COUNT}"


kubectl scale --replicas=${REPLICA_COUNT} deployment/metric-generator
kubectl describe deployment metric-generator


