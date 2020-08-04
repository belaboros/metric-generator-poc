package nl.ah.metricgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MetricgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricgeneratorApplication.class, args);
	}
}
