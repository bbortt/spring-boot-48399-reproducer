package io.github.bbortt.spring_native_bug_reproducer;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class SpringNativeBugReproducerApplication implements CommandLineRunner {

    private static final Logger log = getLogger(SpringNativeBugReproducerApplication.class);

    @Value("${normal.property:undefined}")
    private String normalProperty;

    @Value("${prod.property:undefined}")
    private String prodProperty;

    public static void main(String[] args) {
        SpringApplication.run(SpringNativeBugReproducerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("normalProperty={}, prodProperty={}", normalProperty, prodProperty);
    }
}
