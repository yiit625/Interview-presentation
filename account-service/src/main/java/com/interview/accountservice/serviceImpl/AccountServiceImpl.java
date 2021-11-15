package com.interview.accountservice.serviceImpl;

import com.interview.accountservice.entity.Account;
import com.interview.accountservice.model.AccountDto;
import com.interview.accountservice.repository.AccountRepository;
import com.interview.accountservice.service.AccountService;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;


    public AccountDto get(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account = accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        Optional<Account> account = accountRepository.findById(accountDto.getId());
        Account accountToUpdate = account.map(it -> {
            it.setUsername(accountDto.getUsername());
            it.setSurname(accountDto.getSurname());
            return it;
        }).orElseThrow(IllegalArgumentException::new);
        return modelMapper.map(accountRepository.save(accountToUpdate), AccountDto.class);
    }

    @Override
    public void delete(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
