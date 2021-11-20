package com.interview.accountservice.enums;

import lombok.Getter;

@Getter
public enum RoleEnums {
    ADMIN("ADMIN"),
    USER("USER");

    private String label;

    RoleEnums(String label){
        this.label = label;
    }
}
