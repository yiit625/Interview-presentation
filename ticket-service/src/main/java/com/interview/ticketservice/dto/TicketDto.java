package com.interview.ticketservice.dto;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private String id;

    private String description;

    private String notes;

    private String assignee;

    private Date ticketDate;

    private String priorityType;

    private String ticketStatus;
}
