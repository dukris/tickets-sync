package com.solvd.tickets.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.solvd.tickets.model.Ticket;
import com.solvd.tickets.model.Tickets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Jira tickets.
 */
@Component
@RequiredArgsConstructor
public class JrTickets implements Tickets {

    private final JiraRestClient client;

    @Override
    public Ticket ticket(String id) {
        return new JrTicket(
                id,
                this.client.getIssueClient().getIssue(id).claim()
        );
    }
}
