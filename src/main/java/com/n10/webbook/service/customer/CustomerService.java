package com.n10.webbook.service.customer;

import com.n10.webbook.entity.Cart;
import com.n10.webbook.entity.Customer;
import com.n10.webbook.service.GennericService;

public interface CustomerService extends GennericService<Customer> {

    Cart initCart();
}
