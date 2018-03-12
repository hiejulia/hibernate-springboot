package com.project.hibernate.entity;


import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private int id;

    @Column(name = "name", nullable = false)
    @NotNull
    @NotBlank
    String name;

    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @OneToMany(orphanRemoval = true, mappedBy = "department")
    @OrderBy("post_id")
    private List<Post> posts = new ArrayList<>();



}
