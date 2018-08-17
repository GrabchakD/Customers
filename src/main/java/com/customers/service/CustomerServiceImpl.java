package com.customers.service;

import com.customers.dao.CustomerCSVRepository;
import com.customers.dao.CustomerRepository;
import com.customers.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerCSVRepository csvRepo;

    @Autowired
    private CustomerRepository h2Repo;

    @Override
    public Optional<String> add(Customer customer) {
        return csvRepo.add(customer)
                .map(s -> {
                    customer.setCustomerFileName(s);
                    return customer;
                })
                .map(h2Repo::save)
                .map(Customer::getCustomerFileName);
    }

    @Override
    public Optional<Customer> getByFileName(String fileName) {
        return csvRepo.getByFileName(fileName);
    }
}
