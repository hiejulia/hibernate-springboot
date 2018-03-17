package com.project.hibernate.dao.impl;

import com.project.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import javax.persistence.Query;
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
    public List<User> findByEmail1(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("findByEmail");
        query.setString("email", email);
        return query.list();
    }
}