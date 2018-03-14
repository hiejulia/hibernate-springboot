package com.project.hibernate.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "guest")
@Data
public class Guest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_last_modified")
    protected Date modificationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created")
    protected Date creationDate;

    @Version
    @Column(name = "version")
    protected Integer version;

    @NotNull(message = "Name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull(message = "Address is required")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Phone is required")
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;


}
