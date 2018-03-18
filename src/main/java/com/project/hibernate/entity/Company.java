package com.project.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Car> cars = new HashSet<>();

}
