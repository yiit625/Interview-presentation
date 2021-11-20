package com.interview.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private UUID id;
    private String username;
    private String surname;
    private String email;
    private String passwd;
    private Boolean active;
    private String role;
}
