package com.interview.ticketservice.repository;

import com.interview.ticketservice.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}