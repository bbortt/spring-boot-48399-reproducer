package io.github.bbortt.spring.bug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.util.StreamUtils.copyToString;

@Configuration
public class ProdPropertySourceLoader {

    private static final Logger log = LoggerFactory.getLogger(ProdPropertySourceLoader.class);

    public ProdPropertySourceLoader() throws IOException {
        log.info(
                "File loaded from classpath: {}",
                copyToString(
                        getClass().getClassLoader().getResourceAsStream("application-prod.yaml"), StandardCharsets.UTF_8
                ));
    }
}
