package com.n10.webbook.service.customer;

import com.n10.webbook.entity.Account;
import com.n10.webbook.service.GennericService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends GennericService<Account>, UserDetailsService {
    Account getAccountByUsername(String username);
}
