package com.project.hibernate.repository.impl;


import java.util.Map;

import javax.annotation.PostConstruct;

import com.project.hibernate.entity.Customer;
import com.project.hibernate.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private static final String KEY = "Customer";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, Customer> hashOperations;

    @Autowired
    public CustomerRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    @Override
    public Customer find(Long id) {
        return hashOperations.get(KEY, id);
    }

    @Override
    public Map<Long, Customer> findAll() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void update(Customer customer) {
        hashOperations.put(KEY, customer.getId(), customer);
    }

    @Override
    public void delete(Long id) {
        hashOperations.delete(KEY, id);
    }

}