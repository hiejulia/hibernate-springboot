package com.project.hibernate.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column
    private String contactEmail;

    @Column
    private String contactPhone;

    @OneToMany(orphanRemoval = true, mappedBy = "department")
    List<Post> posts = new ArrayList<>();



}
