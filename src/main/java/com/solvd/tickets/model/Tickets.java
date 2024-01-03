package com.solvd.tickets.model;

import java.time.LocalDate;
import java.util.List;

/**
 * All tickets.
 */
public interface Tickets {

  /**
   * Retrieve all tickets be date.
   *
   * @param date LocalDate
   * @return List of tickets
   */
  List<Ticket> byDate(LocalDate date);

}
