package com.project.hibernate.entity;


import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.TABLE;

@Data
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
//    @TableGenerator(name="tablegen",
//            table="ID_TABLE",
//            pkColumnName="ID",
//            valueColumnName="NEXT_ID")
//    @GeneratedValue(strategy=TABLE,generator="tablegen")
    private Integer id;

    @Column
    String title;


    // transient field

    @Transient
    private String shortText;




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
