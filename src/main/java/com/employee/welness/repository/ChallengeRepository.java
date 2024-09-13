package com.employee.welness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.welness.models.Challenge;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
	