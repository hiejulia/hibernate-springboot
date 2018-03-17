package com.project.hibernate.repository;

import com.project.hibernate.entity.User;
import org.omg.CORBA.INTERNAL;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IUserRepository extends CrudRepository<User, Long> {
//    @Cacheable(value = "findByUserName")
    User findByUserName(String username);
    // find by id
//    User findById(Integer id);
}