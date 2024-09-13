package com.employee.welness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.welness.models.WellnessProgram;
import com.employee.welness.repository.WellnessProgramRepository;

import javax.transaction.Transactional;

@Service
public class WellnessProgramService {

    @Autowired
    private WellnessProgramRepository wellnessProgramRepository;

    public List<WellnessProgram> getAllWellnessPrograms() {
        return wellnessProgramRepository.findAll();
    }

    public Optional<WellnessProgram> getWellnessProgramById(Long id) {
        return wellnessProgramRepository.findById(id);
    }
  
    @Transactional
    public WellnessProgram createWellnessProgram(WellnessProgram wellnessProgram) {
        return wellnessProgramRepository.save(wellnessProgram);
    }
@Transactional
    public WellnessProgram updateWellnessProgram(Long id, WellnessProgram updatedWellnessProgram) {
        Optional<WellnessProgram> existingWellnessProgram = wellnessProgramRepository.findById(id);
        if (existingWellnessProgram.isPresent()) {
            WellnessProgram wellnessProgram = existingWellnessProgram.get();
            wellnessProgram.setWellnessProgramName(updatedWellnessProgram.getWellnessProgramName());
            wellnessProgram.setWellnessProgramStartDate(updatedWellnessProgram.getWellnessProgramStartDate());
            wellnessProgram.setWellnessProgramEndDate(updatedWellnessProgram.getWellnessProgramEndDate());
            wellnessProgram.setCategory(updatedWellnessProgram.getCategory());
            wellnessProgram.setDescription(updatedWellnessProgram.getDescription());
            wellnessProgram.setWellnessProgramStatus(updatedWellnessProgram.getWellnessProgramStatus());
            return wellnessProgramRepository.save(wellnessProgram);
        } else {
            return null; 
        }
    }
@Transactional
    public void deleteWellnessProgram(Long id) {
        wellnessProgramRepository.deleteById(id);
    }
}
