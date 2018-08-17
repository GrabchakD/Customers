package com.customers.conroller;

import com.customers.conroller.payloads.FileNamePayload;
import com.customers.model.Customer;
import com.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.CREATED;


@RestController
public class CustomerController {

    @Autowired
    CustomerService service;

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public ResponseEntity<FileNamePayload> customers(@RequestBody Customer customer) {
        return service.add(customer)
                .map(FileNamePayload::new)
                .map(f -> ResponseEntity.status(CREATED).body(f))
                .orElseGet(ResponseEntity.unprocessableEntity()::build);
    }

    @RequestMapping(value = "/customer/{fileName}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerByUniqFileName(@PathVariable String fileName) {
        return service.getByFileName(fileName)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
