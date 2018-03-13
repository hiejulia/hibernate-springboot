package com.project.hibernate.repository;


import com.project.hibernate.entity.Customer;

import java.util.Map;



public interface ICustomerRepository {

    void save(Customer customer);

    Customer find(Long id);

    Map<Long, Customer> findAll();

    void update(Customer customer);

    void delete(Long id);
}