package com.solvd.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Application.
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class TicketsApplication {

    /**
     * Application start.
     *
     * @param args String[]
     */
    public static void main(final String[] args) {
        SpringApplication.run(TicketsApplication.class, args);
    }

}
