package com.customers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @JsonProperty(value = "mobile_no")
    @Column(name = "MOBILE_NUMBER")
    private Long mobileNumber;
    @JsonIgnore
    @Column(name = "CUSTOMER_FILE_NAME")
    private String customerFileName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCustomerFileName() {
        return customerFileName;
    }

    public void setCustomerFileName(String customerFileName) {
        this.customerFileName = customerFileName;
    }
}
