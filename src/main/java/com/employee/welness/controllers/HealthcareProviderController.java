package com.employee.welness.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.welness.models.HealthcareProvider;
import com.employee.welness.service.HealthcareProviderService;

@RestController
@RequestMapping("/api/healthcare-providers")
public class HealthcareProviderController {

    @Autowired
    private HealthcareProviderService healthcareProviderService;

    // Get all healthcare providers
    @GetMapping
    public List<HealthcareProvider> getAllHealthcareProviders() {
        return healthcareProviderService.getAllHealthcareProviders();
    }

    // Get healthcare provider by ID
    @GetMapping("/{id}")
    public ResponseEntity<HealthcareProvider> getHealthcareProviderById(@PathVariable Long id) {
        Optional<HealthcareProvider> healthcareProvider = healthcareProviderService.getHealthcareProviderById(id);
        return healthcareProvider.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new healthcare provider
    @PostMapping
    public ResponseEntity<HealthcareProvider> createHealthcareProvider(@RequestBody HealthcareProvider healthcareProvider) {
        HealthcareProvider createdHealthcareProvider = healthcareProviderService.createHealthcareProvider(healthcareProvider);
        return new ResponseEntity<>(createdHealthcareProvider, HttpStatus.CREATED);
    }

    // Update a healthcare provider
    @PutMapping("/{id}")
    public ResponseEntity<HealthcareProvider> updateHealthcareProvider(@PathVariable Long id, @RequestBody HealthcareProvider healthcareProvider) {
        HealthcareProvider updatedHealthcareProvider = healthcareProviderService.updateHealthcareProvider(id, healthcareProvider);
        if (updatedHealthcareProvider != null) {
            return ResponseEntity.ok(updatedHealthcareProvider);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a healthcare provider
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthcareProvider(@PathVariable Long id) {
        healthcareProviderService.deleteHealthcareProvider(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
