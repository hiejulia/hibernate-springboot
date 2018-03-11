package com.project.hibernate.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Expertise {

    @Column
    String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
