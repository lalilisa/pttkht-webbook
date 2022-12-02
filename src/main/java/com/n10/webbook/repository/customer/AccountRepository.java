package com.n10.webbook.repository.customer;

import com.n10.webbook.entity.Account;
import com.n10.webbook.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account getAccountByUsername(String username);
}
