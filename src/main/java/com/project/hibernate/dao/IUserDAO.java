package com.project.hibernate.dao;

import javax.transaction.Transactional;

import com.project.hibernate.entity.User;
import org.springframework.data.repository.CrudRepository;

@Transactional
public abstract interface IUserDAO
        extends CrudRepository<User, Long>
{
    public abstract User findByEmail(String email);
}