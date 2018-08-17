package com.customers.service;

import com.customers.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<String> add(Customer customer);

    Optional<Customer> getByFileName(String fileName);
}
