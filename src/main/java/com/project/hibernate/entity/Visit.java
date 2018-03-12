package com.project.hibernate.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "visit")
public class Visit implements Serializable {
    @Id
    @Column(name = "visit_id", nullable = false)
    private int id;

//    private Employee employee;

    private Date date;

    private Boolean status;

}
