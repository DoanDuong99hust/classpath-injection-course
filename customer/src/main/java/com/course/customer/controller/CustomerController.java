package com.course.customer.controller;

import com.course.customer.dto.Customer;
import com.course.customer.service.CustomerService;
import com.course.farm.annotation.FarmAutowire;
import com.course.farm.annotation.FarmController;
import com.course.farm.annotation.FarmGetMapping;

import java.util.List;

@FarmController(path = "/customer")
public class CustomerController {

    @FarmAutowire
    private CustomerService customerService;

    @FarmGetMapping(value = "/get-all-customer")
    public List<Customer> getCustomers() {
        System.out.printf("getCustomers called %s%n", customerService.getAllCustomers());
        return customerService.getAllCustomers();
    }
}
