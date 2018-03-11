package com.project.hibernate.entity;



import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//
@Entity
@Table(name = "user")
@XmlRootElement
////@NamedQueries({
////        @NamedQuery(name = "User.findAll", query = "SELECT s FROM user s")})
@Data
public class User {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name")
    private String userName;


    private String firstName;


    private String lastName;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private int gender;

    @Column
    private Date date_of_birth;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id",fetch = FetchType.LAZY)
//    private List<Contact> contact;


// PROJECT
    @ManyToMany(mappedBy = "members")
    private Set<Project> projects = new HashSet<>();




}