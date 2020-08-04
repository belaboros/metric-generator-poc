# POC to generate metrics for Prometheus with high cardinality 

## Goal
This is a demonstration how a high-cardinality metric causes problems for Prometheus.

Prometheus documentation says not to generate metrics with high-cardinality:
https://prometheus.io/docs/practices/naming/

"CAUTION: Remember that every unique combination of key-value label pairs represents a new time series, which can dramatically increase the amount of data stored. Do not use labels to store dimensions with high cardinality (many different label values), such as user IDs, email addresses, or other unbounded sets of values."

The goal of this POC is to show empirically how much cardinality is still ok.

## How to build

```
./mvnw clean package
```

## How to run

```
mvn spring-boot:run
```

## Metrics exposed

Open actuator endpoints in a browser:
- http://localhost:18080/actuator/prometheus
- http://localhost:8080/actuator/metrics/messages.sent.to.spam
- http://localhost:8080/actuator/metrics
- http://localhost:8080/actuator


## See also:
- Spring initializer: expose metrics for Prometheus 
  <br/>https://www.codeprimers.com/metrics-collection-in-spring-boot-with-micrometer-and-prometheus/
  <br/>https://start.spring.io/
- Spring Scheduled beans:
  <br/>https://dzone.com/articles/running-on-time-with-springs-scheduled-tasks
- Metric collector in Spring 2:
  <br/>https://spring.io/blog/2018/03/16/micrometer-spring-boot-2-s-new-application-metrics-collector
  <br/>https://blog.autsoft.hu/defining-custom-metrics-in-a-spring-boot-application-using-micrometer/
- Java 8+ new DateTime API
  <br/>https://www.baeldung.com/java-8-date-time-intro
  
  
