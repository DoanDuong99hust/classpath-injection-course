package com.course.customer.util;

import com.course.customer.dto.Customer;

import java.util.List;

public class CustomerUtil {

    private CustomerUtil() {
    }

    public static List<Customer> getCustomerList(){
        return List.of(new Customer(1, "customer1", "0123456789", "customer1@demo.com"),
                new Customer(2, "customer2", "012345678", "customer2@demo.com"),
                new Customer(3, "customer3", "012345678", "customer3@demo.com"));
    }
}
