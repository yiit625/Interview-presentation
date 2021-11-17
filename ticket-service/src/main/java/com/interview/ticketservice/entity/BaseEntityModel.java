package com.interview.ticketservice.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntityModel implements Serializable {

    @CreatedDate
    @Column(name = "created_at")
    private Date cretedAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
