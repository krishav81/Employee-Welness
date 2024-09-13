package com.employee.welness.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.employee.welness.models.WellnessProgram;
import com.employee.welness.service.WellnessProgramService;

@RestController
@RequestMapping("/api/wellness-programs")
public class WellnessProgramController {

    @Autowired
    private WellnessProgramService wellnessProgramService;

    // Get all wellness programs
    @GetMapping
    public List<WellnessProgram> getAllWellnessPrograms() {
        return wellnessProgramService.getAllWellnessPrograms();
    }

    // Get wellness program by ID
    @GetMapping("/{id}")
    public ResponseEntity<WellnessProgram> getWellnessProgramById(@PathVariable Long id) {
        Optional<WellnessProgram> wellnessProgram = wellnessProgramService.getWellnessProgramById(id);
        return wellnessProgram.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new wellness program
    @PostMapping
    public ResponseEntity<WellnessProgram> createWellnessProgram(@RequestBody WellnessProgram wellnessProgram) {
        WellnessProgram createdWellnessProgram = wellnessProgramService.createWellnessProgram(wellnessProgram);
        return new ResponseEntity<>(createdWellnessProgram, HttpStatus.CREATED);
    }

    // Update a wellness program
    @PutMapping("/{id}")
    public ResponseEntity<WellnessProgram> updateWellnessProgram(@PathVariable Long id, @RequestBody WellnessProgram wellnessProgram) {
        WellnessProgram updatedWellnessProgram = wellnessProgramService.updateWellnessProgram(id, wellnessProgram);
        if (updatedWellnessProgram != null) {
            return ResponseEntity.ok(updatedWellnessProgram);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a wellness program
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWellnessProgram(@PathVariable Long id) {
        wellnessProgramService.deleteWellnessProgram(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
