package com.interview.accountservice.entity;

import com.datastax.driver.core.DataType;
import com.interview.accountservice.enums.RoleEnums;
import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(value = "accounts")
public class Account {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = DataType.Name.UUID)
    private UUID Id;

    @Column(value = "uname")
    private String username;

    @Column(value = "sname")
    private String surname;

    @Column(value = "email")
    private String email;

    @Column(value = "pwd")
    private String passwd;

    @Column(value = "created_at")
    private Date createdAt;

    @Column(value = "updated_at")
    private Date updateAt;

    @Column(value = "is_active")
    private Boolean active;

    @Column(value = "roles")
    private RoleEnums roles;
}
