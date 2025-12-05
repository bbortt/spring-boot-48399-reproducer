package io.github.bbortt.spring.bug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-prod.yaml")
public class App implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Value(            "${normal.property:undefined}"    )
    private String normalProperty;

    @Value(            "${prod.property:undefined}"    )
    private String prodProperty;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("normalProperty={}, prodProperty={}", normalProperty, prodProperty);
    }
}
