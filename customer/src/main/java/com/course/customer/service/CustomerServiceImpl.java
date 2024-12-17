package com.course.customer.service;

import com.course.customer.dto.Customer;
import com.course.customer.util.CustomerUtil;
import com.course.farm.annotation.FarmService;

import java.util.List;

@FarmService
public class CustomerServiceImpl implements CustomerService {

//    @FarmAutowire
//    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return CustomerUtil.getCustomerList();
    }
}
