package com.student.studentjpa.repository;

import com.student.studentjpa.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
}
