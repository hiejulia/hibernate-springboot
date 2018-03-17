package com.project.hibernate.service;


import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.User;

import java.util.List;



public interface AppointmentService {
    // create one appointment by user
    Appointment createAppointment(Appointment appointment);

    // get all list of appointment in the company
    List<Appointment> findAll();

    // find appointment by id
    Appointment findAppointment(Long id);


    // confirm appointment
    void confirmAppointment(Long id);
    // get all appointment by user
    List<Appointment> findAllByUser(User user);
}