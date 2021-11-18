package com.interview.ticketservice.service;

import com.interview.ticketservice.entity.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
