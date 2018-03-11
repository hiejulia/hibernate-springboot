package com.project.hibernate.repository;


import com.project.hibernate.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // find by id
    Department findById(Integer id);

}