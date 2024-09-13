package com.employee.welness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.welness.models.Challenge;
import com.employee.welness.repository.ChallengeRepository;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public Optional<Challenge> getChallengeById(Long id) {
        return challengeRepository.findById(id);
    }

    public Challenge createChallenge(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public Challenge updateChallenge(Long id, Challenge updatedChallenge) {
        Optional<Challenge> existingChallenge = challengeRepository.findById(id);
        if (existingChallenge.isPresent()) {
            Challenge challenge = existingChallenge.get();
            challenge.setName(updatedChallenge.getName());
            challenge.setDescription(updatedChallenge.getDescription());
            challenge.setStartDate(updatedChallenge.getStartDate());
            challenge.setEndDate(updatedChallenge.getEndDate());
            challenge.setStatus(updatedChallenge.getStatus());
            return challengeRepository.save(challenge);
        } else {
            return null; // Handle challenge not found case
        }
    }

    public void deleteChallenge(Long id) {
        challengeRepository.deleteById(id);
    }
}
