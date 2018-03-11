package com.project.hibernate.dao.impl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.project.hibernate.dao.ContactDAO;
import com.project.hibernate.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ContactDAOImpl implements ContactDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contact> getAllContacts() {
        return null;
    }

    @Override
    public Contact getContactById(String id) {
        return null;
    }

    @Override
    public void addContact(Contact contact) {

    }

    @Override
    public void updateContact(Contact contact) {

    }

    @Override
    public void deleteContact(String id) {

    }

    @Override
    public boolean contactExists(String name) {
        return false;
    }
}
