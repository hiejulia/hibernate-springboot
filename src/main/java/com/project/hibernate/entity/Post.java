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
    private Integer id;

    @Column
    String title;

    @ManyToOne
    Department department;

}
