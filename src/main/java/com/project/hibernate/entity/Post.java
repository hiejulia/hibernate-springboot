package com.project.hibernate.entity;


import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name="department_id")
    Department department;

}
