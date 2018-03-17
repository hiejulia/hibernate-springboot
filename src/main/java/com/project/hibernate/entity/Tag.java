package com.project.hibernate.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subcat_id")
    private Subcategory subcategory;

    @ManyToMany(mappedBy = "categorization")
    private List<Post> posts = new ArrayList<>();
}
