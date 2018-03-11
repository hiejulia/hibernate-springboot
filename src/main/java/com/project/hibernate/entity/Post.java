package com.project.hibernate.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    String title;

    @ManyToOne
    Department department;

}
