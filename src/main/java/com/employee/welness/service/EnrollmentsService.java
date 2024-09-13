package com.employee.welness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.welness.models.Enrollments;
import com.employee.welness.repository.EnrollmentsRepository;


@Service
public class EnrollmentsService {

    @Autowired
    private EnrollmentsRepository enrollmentsRepository;

    public List<Enrollments> getAllEnrollments() {
        return enrollmentsRepository.findAll();
    }

    public Optional<Enrollments> getEnrollmentById(Long id) {
        return enrollmentsRepository.findById(id);
    }

    public Enrollments createEnrollment(Enrollments enrollment) {
        return enrollmentsRepository.save(enrollment);
    }

    public Enrollments updateEnrollment(Long id, Enrollments updatedEnrollment) {
        Optional<Enrollments> existingEnrollment = enrollmentsRepository.findById(id);
        if (existingEnrollment.isPresent()) {
            Enrollments enrollment = existingEnrollment.get();
            enrollment.setEmployee(updatedEnrollment.getEmployee());
            enrollment.setChallenge(updatedEnrollment.getChallenge());
            enrollment.setEvent(updatedEnrollment.getEvent());
            enrollment.setWellnessProgram(updatedEnrollment.getWellnessProgram());
            enrollment.setEventEnrollDate(updatedEnrollment.getEventEnrollDate());
            enrollment.setChallengeEnrollDate(updatedEnrollment.getChallengeEnrollDate());
            enrollment.setChallengeEnrollDate(updatedEnrollment.getWelnessEnrollDate());
            enrollment.setStatus(updatedEnrollment.getStatus());
            return enrollmentsRepository.save(enrollment);
        } else {
            return null; // Handle not found case
        }
    }

    public void deleteEnrollment(Long id) {
        enrollmentsRepository.deleteById(id);
    }
}
