package com.project.hibernate.dao;


import com.project.hibernate.entity.BaseEntity;

import java.util.List;




public interface BaseDAO <T> {

    T insert(T t);

    T update(T t);

    boolean delete(T t);

    List<T> getAllList();
}