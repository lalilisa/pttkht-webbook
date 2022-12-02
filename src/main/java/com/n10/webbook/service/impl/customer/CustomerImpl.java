package com.n10.webbook.service.impl.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.n10.webbook.common.dto.QueryDto;
import com.n10.webbook.common.dto.ResponseListAll;
import com.n10.webbook.entity.Cart;
import com.n10.webbook.entity.Customer;
import com.n10.webbook.repository.customer.CustomerRepository;
import com.n10.webbook.service.GennericService;
import com.n10.webbook.service.customer.AccountService;
import com.n10.webbook.service.customer.AddressService;
import com.n10.webbook.service.customer.CustomerService;
import com.n10.webbook.service.customer.FullNameService;
import com.n10.webbook.service.order.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountService accountService;
    @Autowired
    AddressService addressService;
    @Autowired
    FullNameService fullNameService;
    @Override
    public ResponseListAll findAll(QueryDto queryDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findOneById(long id) {

        return customerRepository.findCustomerById(id);
    }

    @Override
    public Customer create(Customer entity) {
        Customer newCustomer= customerRepository.save(entity);
        Cart newCart= initCart();
        newCustomer.setCart(newCart);
        return this.customerRepository.save(newCustomer);
    }

    @Override
    public Customer update(Customer entity) {
        return null;
    }

    @Override
    public void deleleById(long id) {

    }

    @Autowired
    CartService cartService;
    @Override
    public Cart initCart() {
        Cart newCart=new Cart();
       newCart= cartService.create(newCart);

      return newCart;
    }
}
