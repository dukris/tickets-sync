package com.solvd.tickets.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Jira properties.
 */
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jira")
public class JrProperty {

    private final String username;
    private final String token;
    private final String uri;
    private final String project;

}
