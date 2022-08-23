package com.sunglowsys.service.impl.impl;

import com.sunglowsys.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer update(Customer customer,Long id);

    List<Customer> findAll();

    Customer findById(Long id);

    void delete(Long id);

}
