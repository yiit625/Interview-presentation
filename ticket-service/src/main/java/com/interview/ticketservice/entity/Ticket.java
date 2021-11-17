package com.interview.ticketservice.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.interview.ticketservice.enums.PriorityType;
import com.interview.ticketservice.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ticket")
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket extends BaseEntityModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "notes", length = 1000)
    private String notes;

    @Column(name = "assignee", length = 50)
    private String assignee;

    @Column(name = "ticket_date")
    private Date ticketDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

}