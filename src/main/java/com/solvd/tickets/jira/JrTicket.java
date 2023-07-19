package com.solvd.tickets.jira;

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
    private final String summary;

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public String summary() {
        return this.summary;
    }

}
