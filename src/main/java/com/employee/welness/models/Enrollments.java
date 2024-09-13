package com.employee.welness.models;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name = "wellness_program_id")
    private WellnessProgram wellnessProgram;
    private LocalDate eventEnrollDate;
    private LocalDate challengeEnrollDate;
    private LocalDate welnessEnrollDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    public LocalDate getEventEnrollDate() {
		return eventEnrollDate;
	}

	public void setEventEnrollDate(LocalDate eventEnrollDate) {
		this.eventEnrollDate = eventEnrollDate;
	}

	public LocalDate getChallengeEnrollDate() {
		return challengeEnrollDate;
	}

	public void setChallengeEnrollDate(LocalDate challengeEnrollDate) {
		this.challengeEnrollDate = challengeEnrollDate;
	}

	public LocalDate getWelnessEnrollDate() {
		return welnessEnrollDate;
	}

	public void setWelnessEnrollDate(LocalDate welnessEnrollDate) {
		this.welnessEnrollDate = welnessEnrollDate;
	}

	public Long getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public WellnessProgram getWellnessProgram() {
		return wellnessProgram;
	}

	public void setWellnessProgram(WellnessProgram wellnessProgram) {
		this.wellnessProgram = wellnessProgram;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public Enrollments(Long enrollmentId, Employee employee, Challenge challenge, Event event,
			WellnessProgram wellnessProgram, LocalDate eventEnrollDate, LocalDate challengeEnrollDate,
			LocalDate welnessEnrollDate, Status status) {
		super();
		this.enrollmentId = enrollmentId;
		this.employee = employee;
		this.challenge = challenge;
		this.event = event;
		this.wellnessProgram = wellnessProgram;
		this.eventEnrollDate = eventEnrollDate;
		this.challengeEnrollDate = challengeEnrollDate;
		this.welnessEnrollDate = welnessEnrollDate;
		this.status = status;
	}

	public Enrollments() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}