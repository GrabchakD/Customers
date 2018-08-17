package com.customers.dao;

import com.customers.model.Customer;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Repository
public class CustomerCSVRepositoryImpl implements CustomerCSVRepository {

    @Autowired
    private String directory;

    private final static String FILE_EXTENSION = ".csv";


    @Override
    public Optional<String> add(Customer customer) {

        CSVWriter writer = null;
        String fileName = generateUniqName();
        String path = directory.concat(fileName).concat(FILE_EXTENSION);

        try {
            writer = new CSVWriter(new FileWriter(path));
            writer.writeNext(new String[] {
                    String.valueOf(customer.getId()),
                    customer.getName(),
                    String.valueOf(customer.getAge()),
                    String.valueOf(customer.getMobileNumber())
            }, false);

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return Optional.of(fileName);
    }

    @Override
    public Optional<Customer> getByFileName(String fileName) {
        List<String> list = parser(fileName);

        return Optional.of(createCustomer(list));
    }

    private Customer createCustomer(List<String> list) {
        Customer customer = new Customer();
        customer.setId(Long.valueOf(list.get(0)));
        customer.setName(list.get(1));
        customer.setAge(Integer.valueOf(list.get(2)));
        customer.setMobileNumber(Long.valueOf(list.get(3)));

        return customer;
    }

    private List<String> parser(String fileName) {
        Scanner scanner = null;
        List<String> list = new ArrayList<>();
        String path = directory.concat(fileName).concat(FILE_EXTENSION);

        try {
            scanner = new Scanner(new File(path));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            list.add(scanner.next().replace("\n", ""));
        }

        scanner.close();

        return list;
    }

    private String generateUniqName() {
        return UUID.randomUUID().toString();
    }
}
