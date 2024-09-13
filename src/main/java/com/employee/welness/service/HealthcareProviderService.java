package com.employee.welness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.welness.models.HealthcareProvider;
import com.employee.welness.repository.HealthcareProviderRepository;

@Service
public class HealthcareProviderService {

    @Autowired
    private HealthcareProviderRepository healthcareProviderRepository;

    public List<HealthcareProvider> getAllHealthcareProviders() {
        return healthcareProviderRepository.findAll();
    }

    public Optional<HealthcareProvider> getHealthcareProviderById(Long id) {
        return healthcareProviderRepository.findById(id);
    }

    public HealthcareProvider createHealthcareProvider(HealthcareProvider healthcareProvider) {
        return healthcareProviderRepository.save(healthcareProvider);
    }

    public HealthcareProvider updateHealthcareProvider(Long id, HealthcareProvider updatedHealthcareProvider) {
        Optional<HealthcareProvider> existingHealthcareProvider = healthcareProviderRepository.findById(id);
        if (existingHealthcareProvider.isPresent()) {
            HealthcareProvider healthcareProvider = existingHealthcareProvider.get();
            healthcareProvider.setDoctorname(updatedHealthcareProvider.getDoctorname());
            healthcareProvider.setLocation(updatedHealthcareProvider.getLocation());
            healthcareProvider.setSpecialization(updatedHealthcareProvider.getSpecialization());
            healthcareProvider.setStatus(updatedHealthcareProvider.getStatus());
            healthcareProvider.setTimings(updatedHealthcareProvider.getTimings());
            healthcareProvider.setContact(updatedHealthcareProvider.getContact());
            return healthcareProviderRepository.save(healthcareProvider);
        } else {
            return null; 
        }
    }

    public void deleteHealthcareProvider(Long id) {
        healthcareProviderRepository.deleteById(id);
    }
}
