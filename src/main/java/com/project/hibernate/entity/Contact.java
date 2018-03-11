package com.project.hibernate.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "contact")
@XmlRootElement
//@NamedQueries({
//        @NamedQuery(name = "Contact.findAll", query = "SELECT s FROM contact s")})
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
//        allowGetters = true)
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer contactId;

    @Size(max = 255)
    @Column(name = "contact")
    @NotBlank
    private String contact;

    @NotNull
    private String title;

    @NotBlank
    private String content;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    // CREATED DATE
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


}