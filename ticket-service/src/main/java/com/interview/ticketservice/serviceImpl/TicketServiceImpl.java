package com.interview.ticketservice.serviceImpl;

import com.interview.ticketservice.dto.TicketDto;
import com.interview.ticketservice.entity.Ticket;
import com.interview.ticketservice.enums.PriorityType;
import com.interview.ticketservice.enums.TicketStatus;
import com.interview.ticketservice.repository.TicketRepository;
import com.interview.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDto save(TicketDto ticketDto) {
        // Ticket Entity
        if (ticketDto.getTicketDate() == null)
            throw new IllegalArgumentException("Ticket Date can not be blank");

        Ticket ticket = new Ticket();

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        //TO DO
        //ticket.setAssignee("");
        // mysql kaydet
        ticketRepository.save(ticket);
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }
}