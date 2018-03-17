package com.project.hibernate.entity;


import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Integer id;

    @Column
    String title;

    // RELATIONSHIP WITH OTHER TABLE
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "post_categorization",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> categorization = new ArrayList<>();



    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

}
