package com.project.hibernate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

// Repository class : service
@Service
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

}