package com.solvd.tickets.jobs;

import com.solvd.tickets.model.Ticket;
import com.solvd.tickets.model.Tickets;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * Job to retrieve tickets every day.
 */
@Component
@RequiredArgsConstructor
public class RetrieveTickets implements Job {

  /**
   * Tickets.
   */
  private final Tickets tickets;

  @Override
  @Scheduled(fixedDelayString = "${application.delay}")
  public void schedule() {
    List<Ticket> issues = this.tickets.byDate(LocalDate.now());
    /*
     * @todo #16:60min/DEV send issues to Harvest.
     */
  }

}
