package com.employee.welness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.welness.models.HealthcareProvider;

public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Long> {
   
}
