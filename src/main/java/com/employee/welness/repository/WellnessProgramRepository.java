package com.employee.welness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.welness.models.WellnessProgram;

public interface WellnessProgramRepository extends JpaRepository<WellnessProgram, Long> {

}	
