package com.customers.dao;

import com.customers.model.Customer;

import java.util.Optional;

public interface CustomerCSVRepository {

    Optional<String> add(Customer customer);

    Optional<Customer> getByFileName(String fileName);
}
