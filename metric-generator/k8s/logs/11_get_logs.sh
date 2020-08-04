#!/bin/bash
# Query the latest 10-10 logs records of log-generator PODs running in K8S



rm *.log


PODS=$(kubectl get pods -o custom-columns=POD_NAME:.metadata.name | grep metric-generator)
#echo -e "metric-generator PODs:\n${PODS}"

for POD in ${PODS}; do
    echo -e "\n\nPOD:${POD}" | tee -a metric-generator-PODs.log
    echo "$(kubectl get pods | grep ${POD})" | tee -a metric-generator-PODs.log
    echo -e "..." | tee -a metric-generator-PODs.log
    kubectl logs --tail=5 ${POD} | tee -a metric-generator-PODs.log
done

