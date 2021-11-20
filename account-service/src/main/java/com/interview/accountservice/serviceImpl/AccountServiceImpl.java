package com.interview.accountservice.serviceImpl;

import com.interview.accountservice.entity.Account;
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
    public Account save(AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        account.setCreatedAt(new Date());
        account.setUpdateAt(new Date());
        return accountRepository.save(account);
    }

    @Override
    public Account update(AccountDto accountDto) {
        Account account = accountRepository.findById(accountDto.getId()).orElseThrow(IllegalArgumentException::new);
        account.setUsername(accountDto.getUsername());
        account.setSurname(accountDto.getSurname());
        account.setPasswd(accountDto.getPasswd());
        account.setEmail(accountDto.getEmail());
        account.setActive(accountDto.getActive());
        account.setUpdateAt(new Date());
        return accountRepository.save(account);
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
