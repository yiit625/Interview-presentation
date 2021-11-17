package com.interview.ticketservice.api;

import com.interview.ticketservice.dto.TicketDto;
import com.interview.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/ticket")
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TicketApi {
    private final TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<TicketDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.save(ticketDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable String id,
                                                  @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.update(id, ticketDto));
    }
}
