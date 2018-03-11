package com.project.hibernate.repository;


import com.project.hibernate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByCategoryId(Integer id);

}
