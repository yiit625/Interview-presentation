package com.interview.accountservice.service;

import com.interview.accountservice.entity.Account;
import com.interview.client.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto get(String id);

    AccountDto save(AccountDto accountDto);

    AccountDto update(AccountDto accountDto);

    void delete(String id);

    List<Account> findAll();
}
