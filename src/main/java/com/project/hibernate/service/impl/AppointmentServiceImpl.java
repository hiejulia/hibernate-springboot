package com.project.hibernate.service.impl;

import com.project.hibernate.entity.Appointment;
import com.project.hibernate.entity.User;
import com.project.hibernate.repository.impl.AppointmentRepository;
import com.project.hibernate.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public Appointment createAppointment(Appointment appointment) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return null;
    }

    @Override
    public Appointment findAppointment(Long id) {
        return null;
    }

    @Override
    public void confirmAppointment(Long id) {

    }

    @Override
    public List<Appointment> findAllByUser(User user) {
        return null;
    }
}
