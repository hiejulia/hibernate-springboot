package com.project.hibernate.service.impl;



import com.project.hibernate.entity.Company;
import com.project.hibernate.service.CompanyService;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service(value = "companyServiceCriteriaAPI")
public class CompanyServiceCriteriaAPIImpl implements CompanyService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company getCompanyWithDepartments(Integer companyId) {
        return null;
    }

    @Override
    public Company getCompanyWithDepartmentsAndEmployees(Long companyId) {
        return null;
    }

    @Override
    public Company getCompanyWithDepartmentsAndEmployeesAndOffices(Long companyId) {
        return null;
    }

    @Override
    public Company getCompanyWithCars(Long companyId) {
        return null;
    }
}
