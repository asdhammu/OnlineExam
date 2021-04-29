package edu.utdallas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.lang.management.ManagementFactory;

@EnableTransactionManagement
@SpringBootApplication
public class App extends SpringBootServletInitializer {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        MDC.put("process_id",
                ManagementFactory.getRuntimeMXBean().getName());
        SpringApplication.run(App.class, args);
    }

}
