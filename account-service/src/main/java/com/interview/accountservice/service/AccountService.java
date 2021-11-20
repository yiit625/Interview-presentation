package com.interview.accountservice.service;

import com.interview.accountservice.entity.Account;
import com.interview.client.dto.AccountDto;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface AccountService {

    AccountDto get(UUID id);

    Account save(AccountDto accountDto);

    Account update(AccountDto accountDto);

    void delete(UUID id);

    List<Account> findAll();

    List<Account> ListAll(Integer page, Integer size);
}
