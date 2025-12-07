package io.github.bbortt.spring_native_bug_reproducer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
class SpringNativeBugReproducerApplicationTests {

	@Test
	void contextLoads() {
	}
}
