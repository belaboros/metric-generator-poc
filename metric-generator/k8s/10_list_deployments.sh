#!/bin/bash



echo "kubectl get deployments"
kubectl get deployments



echo -e "\n\n\nkubectl describe deployment log-generator"
kubectl describe deployment metric-generator