package com.interview.accountservice.service;

import com.interview.accountservice.model.AccountDto;
import org.springframework.data.domain.Slice;

import java.awt.print.Pageable;

public interface AccountService {

    AccountDto get(String id);

    AccountDto save(AccountDto accountDto);

    AccountDto update(String id, AccountDto accountDto);

    void delete(String id);

    Slice<AccountDto> findAll(Pageable pageable);
}
