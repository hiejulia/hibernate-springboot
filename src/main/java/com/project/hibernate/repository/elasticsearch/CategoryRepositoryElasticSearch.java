package com.project.hibernate.repository.elasticsearch;

import com.project.hibernate.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CategoryRepositoryElasticSearch extends ElasticsearchRepository<Category, String> {

    List<Category> findByName(String name);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"category.name\": \"?0\"}}]}}")
    List<Category> findByNameUsingCustomQuery(String name);

    // FIND BY ID BETWEEN
    public List < Category>  findByIdBetween(Integer beginning, Integer end);



}