package com.project.hibernate.dao.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    @Autowired
    EntityManager entityManager;


    public Person find(Integer id) {

        final EntityManager em = entityManager;
        try {
            return em.find(Person.class, id);
        } catch (RuntimeException e) {
            LOGGER.error("failed to find person id {} :{}",id, e.getMessage());
            return null;
        }
    }

    public Person save(String name, String address, String phone) {
        final EntityManager em = entityManager;
        final EntityTransaction trx = em.getTransaction();

        Person person = new Person(name, address, phone);

        try {

            trx.begin();
            em.persist(person);
            trx.commit();
            return person;

        } catch (RuntimeException e) {
            if (trx != null && trx.isActive()) {
                trx.rollback();
            }
            LOGGER.error("failed to persist person {} :{}",name, e.getMessage());
            return null;
        }
    }

    public List<Person> findName(String name) {
        if(!StringUtils.isEmpty(name)){
            name = name + "%";
        } else return new ArrayList<>();
        final EntityManager em = entityManager;
        try {
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.name LIKE :NAME");
            query.setParameter("NAME", name);
            return (List<Person>) query.getResultList();
        } catch (RuntimeException e) {
            LOGGER.error("failed to find person name {} :{}",name, e.getMessage());
            return null;
        }
    }
}
