package com.project.hibernate.entity;


import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// job title
enum JobTitle {
    Manager, Intern, Enginner, Assistant, Worker, Leader, ProjectManager
}


@EnableJpaAuditing //add enable jpa auditing
@Entity
@Table(name="Employee")
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="employee_id", unique=true)
    @NotNull
    private int id;

    @NotNull
    @Column(name="SSN",unique = true)
    private String ssn;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="DOB")
    @Type(type="date")
    private Date dateOfBirth;

    @NotNull
    @Column(name="job_title")
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @NotNull
    @Column(name="Joining_date")
    private Date joiningDate;

    @NotNull
    @Column(name="salary")
    private int salary;

    @Column(name="apt_no")
    private String aptNo;

    @NotNull
    @Column(name="street_name")
    private String streetName;

    @NotNull
    @Column(name="city")
    private String city;

    @NotNull
    @Column(name="zipcode")
    private String zipCode;

    @JsonIgnore
    @OneToMany(cascade={CascadeType.ALL})
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="employee_Id", referencedColumnName="employee_Id")
    private Set<EmployeeKin> employeesKins;

    // for testing purpose
    private String department;





}
