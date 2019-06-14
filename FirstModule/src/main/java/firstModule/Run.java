package firstModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Test entry point for First Module
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Run {
    public static void main(String[] args) { SpringApplication.run(Run.class, args); }
}

