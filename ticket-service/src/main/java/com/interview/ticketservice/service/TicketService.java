package com.interview.ticketservice.service;

import com.interview.ticketservice.dto.TicketDto;

public interface TicketService {
    TicketDto save(TicketDto ticketDto);

    TicketDto update(String id, TicketDto ticketDto);

    TicketDto getById(String ticketId);

}
