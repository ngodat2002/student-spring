package com.student.studentjpa.service;

import com.student.studentjpa.entity.Employee;
import com.student.studentjpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee save(Employee product) {
        return employeeRepository.save(product);
    }
}
