package com.employee.welness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employee.welness.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}