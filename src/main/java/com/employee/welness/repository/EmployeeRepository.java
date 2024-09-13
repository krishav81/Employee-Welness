package com.employee.welness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.welness.models.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByUsername(String username);
    Optional<Employee> findById(Integer id);
}
