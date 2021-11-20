package com.interview.accountservice.repository;

import com.interview.accountservice.entity.Account;
import feign.Param;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {

    @Query("SELECT * FROM accounts WHERE id = :id")
    Account findById(@Param("id") UUID id);

}
