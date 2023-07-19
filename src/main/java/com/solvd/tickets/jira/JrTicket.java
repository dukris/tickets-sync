package com.solvd.tickets.jira;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.solvd.tickets.model.Ticket;
import lombok.RequiredArgsConstructor;

/**
 * Jira ticket.
 */
@RequiredArgsConstructor
public class JrTicket implements Ticket {

    /**
     * Id.
     */
    private final String id;

    /**
     * Issue.
     */
    private final Issue issue;

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public Issue issue() {
        return this.issue;
    }

}
