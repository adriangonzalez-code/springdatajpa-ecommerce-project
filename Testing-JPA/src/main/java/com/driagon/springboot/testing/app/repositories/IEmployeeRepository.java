package com.driagon.springboot.testing.app.repositories;

import com.driagon.springboot.testing.app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}