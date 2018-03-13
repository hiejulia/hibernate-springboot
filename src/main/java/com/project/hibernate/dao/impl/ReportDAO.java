package com.project.hibernate.dao.impl;


import com.egorbratuhin.dao.ReportsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

/**
 * layer for interaction with models and performing DB operations
 */
@Repository("dataRepository")
public class DataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ReportsEntity> getAllTasks(Date startDate, Date endDate) {
        return entityManager.createQuery("from ReportsEntity " +
                "where (start_date >= :startDate) AND " +
                "(end_date <= :endDate)", ReportsEntity.class)
                .setParameter("startDate", startDate, TemporalType.DATE)
                .setParameter("endDate", endDate, TemporalType.DATE)
                .getResultList();
    }

    public List<ReportsEntity> getAllTasks(String performer, Date startDate, Date endDate) {
        return entityManager.createQuery(
                "from ReportsEntity " +
                        "where (performer LIKE :custPerformer) AND " +
                        "(start_date >= :startDate) AND " +
                        "(end_date <= :endDate)", ReportsEntity.class)
                .setParameter("custPerformer", performer)
                .setParameter("startDate", startDate, TemporalType.DATE)
                .setParameter("endDate", endDate, TemporalType.DATE)
                .getResultList();
    }

    public List<String> getPerformers() {
        return entityManager.createQuery("SELECT distinct performer FROM ReportsEntity", String.class).getResultList();
    }
}