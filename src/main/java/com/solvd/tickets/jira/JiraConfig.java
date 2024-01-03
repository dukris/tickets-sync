package com.solvd.tickets.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * Jira configuration.
 */
@Configuration
@RequiredArgsConstructor
public class JiraConfig {

  /**
   * Jira properties.
   */
  private final JiraProperty property;

  /**
   * Create JiraRestClient.
   *
   * @return JiraRestClient
   */
  @Bean
  public JiraRestClient client() {
    return new AsynchronousJiraRestClientFactory()
      .createWithBasicHttpAuthentication(
        URI.create(this.property.getUri()),
        this.property.getUsername(),
        this.property.getToken()
      );
  }

}
