package nl.ah.metricgenerator;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Increment an exposed metric for Prometheus.
 */
@Component
public class MetricGenerator {

    /** How many metrics to be generated in a second   */
    @Value("${speed:1}")
    private int speed = -1;
    private static boolean first_call = true;

    @Autowired
    private MeterRegistry mr;

    private static final String[] SOURCE_DB = {
            "boff",
            "cwms1",
            "ecdt" ,
            "ecom" ,
            "emda" ,
            "foff"
    };
    private static final String[] CONTRACT_ID = {
            "CM500101",
            "CM500102",
            "CM500103",
            "CM500104",
            "CM500205"
    };
    private static final Random rnd = new Random();

    private static long count = 0;

    MetricGenerator() {
    }

    @Scheduled(fixedDelay = 1000)
    public void generateMetric() {
        if (first_call) {
            System.out.println("speed=" + speed);
            System.out.println("Generating speed=" + speed + " metrics/sec.");
            first_call = false;
        }

        for (int i=0; i<speed; i++) {
            count++;
            String source_db = getRandom(SOURCE_DB);
            String contract_id = getRandom(CONTRACT_ID);
            String creation_datetime = LocalDateTime.now().toString();
            mr.counter("messages.sent.to.spam",
                    "source.db", source_db,
                    "contract.id", contract_id,
                    "creation_datetime", creation_datetime
            )
                    .increment();

            System.out.println(count + ". metric incremented: {" + source_db + " ; " + contract_id + " ; " + creation_datetime + "}");
        }
    }

    private static String getRandom(String[] list) {
        return list[rnd.nextInt(list.length)];
    }
}


