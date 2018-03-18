package com.project.hibernate.entity;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id", updatable = false, nullable = false)
    private int id;

    private String street;

    private String houseNumber;

    private String zipCode;
}