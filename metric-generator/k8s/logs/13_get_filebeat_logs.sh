#!/bin/bash


rm *.log


PODS=$(kubectl get pods -o custom-columns=POD_NAME:.metadata.name -n kube-system | grep filebeat)
#echo -e "FileBeat PODS:\n${PODS}"

for POD in ${PODS}; do
    echo -e "\n\n${POD}"
    kubectl -n kube-system logs ${POD} > ${POD}.log
done


