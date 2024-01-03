package com.solvd.tickets.jira;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Jira properties.
 */
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "jira")
public class JiraProperty {

  /**
   * Username.
   */
  private final String username;

  /**
   * Token.
   */
  private final String token;

  /**
   * Uri.
   */
  private final String uri;

  /**
   * Project's id.
   */
  private final String project;

}
