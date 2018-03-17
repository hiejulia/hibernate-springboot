package com.project.hibernate.entity;


import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private int appointmentId;

    private Date date;

    private String location;

    private String description;

    private boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
