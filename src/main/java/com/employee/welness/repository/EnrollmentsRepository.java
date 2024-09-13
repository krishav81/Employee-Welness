package com.employee.welness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.welness.models.Enrollments;

public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {

}
