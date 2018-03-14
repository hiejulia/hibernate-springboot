package com.project.hibernate.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="category")
@EntityListeners(AuditingEntityListener.class)
@Data
@Document(indexName = "category",type = "category",shards = 1, replicas = 0, refreshInterval = "-1")
public class Category implements Serializable{
    // id
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="category_id",nullable = false)
    private int categoryId;

    @Column(name="name")
    private String name;



}