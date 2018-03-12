package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String content;

//
//    private Department department;

    @NotNull
    private Date deadline;

    @NotNull
    private String status;

    @OneToOne
    private ProjectManager projectManager;
//
//    @ManyToMany
//    @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<User> members = new HashSet<>();



}
