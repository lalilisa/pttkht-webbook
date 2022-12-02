package com.n10.webbook.repository.customer;

import com.n10.webbook.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @EntityGraph(value = "customer-fetch")
    Customer findCustomerById(long id);
}
