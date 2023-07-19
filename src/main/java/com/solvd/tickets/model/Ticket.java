package com.solvd.tickets.model;

import com.atlassian.jira.rest.client.api.domain.Issue;

/**
 * Ticket.
 */
public interface Ticket {

    /**
     * Id.
     *
     * @return Id
     */
    String id();

    /**
     * Issue.
     *
     * @return Issue
     */
    Issue issue();

}
