package com.project.hibernate.dao.impl;

import com.project.hibernate.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl {

    @Autowired(required = false)
    private SessionFactory sessionFactory;

//    @Override
    public List<User> findByEmail(String email) {
        return this.sessionFactory.getCurrentSession()
                .createQuery("from user u where u.email = :email")
                .setString("email", email)
                .list();
    }
}