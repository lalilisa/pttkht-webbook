package com.n10.webbook.service.impl.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Account;
import com.n10.webbook.repository.customer.AccountRepository;
import com.n10.webbook.service.GennericService;
import com.n10.webbook.service.customer.AccountService;
import com.n10.webbook.service.impl.base.AbstractJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class AccountImpl extends AbstractJpaDAO<Account> implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    public AccountImpl() {
        super(Account.class);
    }

    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return this.findsEntity(queryDto);
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findOneById(long id) {
        return null;
    }

    @Override
    public Account create(Account entity) {
        entity.setPassword(entity.hashPassword(entity.getPassword()));
       return accountRepository.save(entity);
    }

    @Override
    public Account update(Account entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = this.getAccountByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> roles = new HashSet<>();
        return new User(user.getUsername(), user.getPassword(), roles);
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername(username);
    }
}
