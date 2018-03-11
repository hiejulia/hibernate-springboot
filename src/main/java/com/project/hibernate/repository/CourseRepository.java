package com.project.hibernate.repository;


import com.project.hibernate.entity.Course;
import org.apache.catalina.Manager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findByCourseId(Integer id);

}