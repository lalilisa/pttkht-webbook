package com.n10.webbook.controller.customer;


import com.n10.webbook.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("")
    public ResponseEntity<?> allCustomer(){
        return  ResponseEntity.ok(customerService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id){
        return  ResponseEntity.ok(customerService.findOneById(id));
    }
}
