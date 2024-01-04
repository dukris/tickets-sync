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

package com.solvd.tickets.jobs;

import com.solvd.tickets.tickets.Ticket;
import com.solvd.tickets.tickets.Tickets;
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
     * @todo #16:60min/DEV export tickets to Harvest.
     *   We need to send the tickets to Harvest using appropriate API.
     */
  }

}
