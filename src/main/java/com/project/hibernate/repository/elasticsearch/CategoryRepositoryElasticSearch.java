package com.project.hibernate.repository.elasticsearch;

import com.project.hibernate.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CategoryRepositoryElasticSearch extends ElasticsearchRepository<Category, String> {

    Page<Category> findByName(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"category.name\": \"?0\"}}]}}")
    Page<Category> findByNameUsingCustomQuery(String name, Pageable pageable);
}