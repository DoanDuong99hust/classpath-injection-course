package com.course.customer.repository;

import com.course.customer.dto.Customer;
import com.course.customer.util.CustomerUtil;
import com.course.farm.abtract.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CustomerRepository extends Repository<Customer, Long> {

    default List<Customer> getEntity() {
        return CustomerUtil.getCustomerList();
    }
}
