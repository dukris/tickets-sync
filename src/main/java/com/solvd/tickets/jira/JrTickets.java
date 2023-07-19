package com.solvd.tickets.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.solvd.tickets.config.JrProperty;
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
public class JrTickets implements Tickets {

    /**
     * Jira client.
     */
    private final JiraRestClient client;

    /**
     * Jira properties.
     */
    private final JrProperty property;

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
                                new JrTicket(
                                        issue.getKey(),
                                        issue.getSummary()
                                )
                        )
                );
        return tickets;
    }
}
