package com.interview.accountservice.serviceImpl;

import com.datastax.driver.core.utils.UUIDs;
import com.interview.accountservice.entity.Account;
import com.interview.accountservice.enums.RoleEnums;
import com.interview.accountservice.repository.AccountRepository;
import com.interview.accountservice.service.AccountService;
import com.interview.client.dto.AccountDto;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;


    public AccountDto get(UUID id) {
        Account account = accountRepository.findById(id);
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public Account save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setId(UUIDs.timeBased());
        account.setCreatedAt(new Date());
        account.setUpdateAt(new Date());
        account.setRoles(RoleEnums.valueOf(accountDto.getRole()));
        return accountRepository.save(account);
    }

    @Override
    public Account update(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId());

        account.setUsername(accountDto.getUsername());
        account.setSurname(accountDto.getSurname());
        account.setPasswd(accountDto.getPasswd());
        account.setEmail(accountDto.getEmail());
        account.setActive(accountDto.getActive());
        account.setUpdateAt(new Date());
        account.setRoles(RoleEnums.valueOf(accountDto.getRole()));
        return accountRepository.save(account);
    }

    @Override
    public void delete(UUID id) {
        Account account = accountRepository.findById(id);
        accountRepository.delete(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> ListAll(Integer page, Integer size) {
        int currpage = 0;
        Slice<Account> slice = accountRepository.findAll(CassandraPageRequest.first(size));
        while(slice.hasNext() && currpage < page) {
            slice = accountRepository.findAll(slice.nextPageable());
            currpage++;
        }
        return slice.getContent();
    }
}
