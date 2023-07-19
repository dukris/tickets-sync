package com.solvd.tickets.model;

/**
 * All tickets.
 */
public interface Tickets {

    /**
     * Get ticket by id.
     *
     * @param id Id
     * @return List of tickets
     */
    Ticket ticket(String id);

}
