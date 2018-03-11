package com.project.hibernate.dao;

import java.util.List;

import com.project.hibernate.entity.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface ContactDAO {

    List<Contact> getAllContacts();

    Contact getContactById(String id);

    void addContact(Contact contact);

    void updateContact(Contact contact);

    void deleteContact(String id);

    boolean contactExists(String name);


}
