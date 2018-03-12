package com.project.hibernate.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
@Table(name="meeting")
@SequenceGenerator(name="seqId",sequenceName="SEQ_MEETING")
public class Meeting extends BaseEntity {

    @Column
    private String name;


    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "meeting_department",
            joinColumns = {@JoinColumn(name = "MEETING_ID" )},
            inverseJoinColumns = {@JoinColumn(name = "DEPARTMENT_ID")})
    private List<Department> departmentList;



}