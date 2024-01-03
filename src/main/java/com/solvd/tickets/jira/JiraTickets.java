/*
 * Copyright (c) 2024 Tickets Sync
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to read
 * the Software only. Permissions is hereby NOT GRANTED to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.solvd.tickets.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.solvd.tickets.model.Ticket;
import com.solvd.tickets.model.Tickets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Jira tickets.
 */
@Component
@RequiredArgsConstructor
public class JiraTickets implements Tickets {

  /**
   * Jira client.
   */
  private final JiraRestClient client;

  /**
   * Jira properties.
   */
  private final JiraProperty property;

  @Override
  public List<Ticket> byDate(final LocalDate date) {
    List<Ticket> tickets = new ArrayList<>();
    this.client.getSearchClient()
      .searchJql(String.format(
          "project=%s AND status=Done AND updated=%s",
          this.property.getProject(),
          date
        )
      ).claim()
      .getIssues()
      .forEach(issue -> tickets.add(
          new JiraTicket(
            issue.getKey(),
            issue.getSummary()
          )
        )
      );
    return tickets;
  }
}
