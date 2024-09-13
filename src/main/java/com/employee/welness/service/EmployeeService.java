package com.employee.welness.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.welness.models.Employee;
import com.employee.welness.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setEmail(updatedEmployee.getEmail());
            employee.setUsername(updatedEmployee.getUsername());
            employee.setPassword(updatedEmployee.getPassword());
            employee.setHeight(updatedEmployee.getHeight());
            employee.setWeight(updatedEmployee.getWeight());
            employee.setBloodGroup(updatedEmployee.getBloodGroup());
            employee.setHobby(updatedEmployee.getHobby());
            employee.setRoles(updatedEmployee.getRoles());
            return employeeRepository.save(employee);
        } else {
            return null; 
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
