package com.employee.welness.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.employee.welness.models.Enrollments;
import com.employee.welness.service.EnrollmentsService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentsController {

    @Autowired
    private EnrollmentsService enrollmentsService;

    // Get all enrollments
    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Enrollments> getAllEnrollments() {
        return enrollmentsService.getAllEnrollments();
    }

    // Get enrollment by ID
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Enrollments> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollments> enrollment = enrollmentsService.getEnrollmentById(id);
        return enrollment.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new enrollment
    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Enrollments> createEnrollment(@RequestBody Enrollments enrollment) {
        Enrollments createdEnrollment = enrollmentsService.createEnrollment(enrollment);
        return new ResponseEntity<>(createdEnrollment, HttpStatus.CREATED);
    }

    // Update an enrollment
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Enrollments> updateEnrollment(@PathVariable Long id, @RequestBody Enrollments enrollment) {
        Enrollments updatedEnrollment = enrollmentsService.updateEnrollment(id, enrollment);
        if (updatedEnrollment != null) {
            return ResponseEntity.ok(updatedEnrollment);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an enrollment
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentsService.deleteEnrollment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
