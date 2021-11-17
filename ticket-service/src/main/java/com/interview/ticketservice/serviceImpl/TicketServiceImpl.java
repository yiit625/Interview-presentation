package com.interview.ticketservice.serviceImpl;

import com.interview.client.AccountServiceClient;
import com.interview.client.dto.AccountDto;
import com.interview.ticketservice.dto.TicketDto;
import com.interview.ticketservice.entity.Ticket;
import com.interview.ticketservice.enums.PriorityType;
import com.interview.ticketservice.enums.TicketStatus;
import com.interview.ticketservice.repository.TicketRepository;
import com.interview.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;

    //private final AccountServiceClient accountServiceClient;

    @Override
    public TicketDto save(TicketDto ticketDto) {
        // Ticket Entity
        if (ticketDto.getTicketDate() == null)
            throw new IllegalArgumentException("Ticket Date can not be blank");

        Ticket ticket = new Ticket();
        //ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        //ticket.setAssignee(accountDtoResponseEntity.getBody().getId());
        ticket.setCretedAt(new Date());
        ticket.setUpdatedAt(new Date());

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
