package com.project.hibernate.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//

//@XmlRootElement
////@NamedQueries({
////
//      @NamedQuery(name = "User.findAll", query = "SELECT s FROM user s")})
@Data
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name = "findByEmail",
                query = "from User u where u.email = :email"
        )
//        @NamedQuery(
//                name = "findByEmailAndPassword",
//                query = "from User u where u.email= :email and u.password = :password"
//        ),
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name")
    private String userName;

    @Column
    private String firstName;

    @Column
    private String lastName;


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    @Transient
    private String password;

    @Column(name="email", nullable=false,unique = true)
    @Email(message = "*Please provide a valid e-mail address.")
    private String email;

//    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column
    private Date date_of_birth;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id",fetch = FetchType.LAZY)
//    private List<Contact> contact;


// PROJECT
//    @ManyToMany(mappedBy = "members")
//    private Set<Project> projects = new HashSet<>();
////
    // role
    @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns = { @JoinColumn(name="user_id")},
            inverseJoinColumns = { @JoinColumn(name="role_id")}
    )
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Contact contact;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="department_id")
    @JsonBackReference
    private Department department;


    // UPDATE USER ENTITY WITH MEETUPS ENTITY RELATIONSHIP
    @OneToMany
    @JoinColumn(name = "organizer_user_id")
    private List<Meetup> meetupsOrganized = new ArrayList<>();

    @ManyToMany(mappedBy = "attendees")
    private List<Meetup> meetupsAttending = new ArrayList<>();

}