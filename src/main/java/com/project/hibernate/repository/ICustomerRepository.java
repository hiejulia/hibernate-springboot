package com.project.hibernate.repository;


import com.project.hibernate.entity.Customer;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Customer findOneById(Long id);
}