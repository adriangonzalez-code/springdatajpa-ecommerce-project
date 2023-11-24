package com.driagon.springboot.testing.app.repositories;

import com.driagon.springboot.testing.app.models.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private IEmployeeRepository repository;

    // Unit test for save employee operation

    @Test
    @DisplayName("JUnit test for save employee operation")
    void givenEmployee_whenSave_thenReturnSavedEmployee() {

        // Given - Precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Ramesh")
                .email("ramesh@mail.com")
                .build();

        // When - Action or behaviour that are going test
        Employee savedEmployee = this.repository.save(employee);

        // Then - Verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @DisplayName("Junit test for get all employees operation")
    @Test
    void givenEmployeesList_whenFindAll_thenEmployeesList() {
        // Given - Precondition or setup
        Employee employee1 = Employee.builder()
                .firstName("Ramesh")
                .lastName("Ramesh")
                .email("ramesh@mail.com")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("John")
                .lastName("Cena")
                .email("john.cena@mail.com")
                .build();

        this.repository.save(employee1);
        this.repository.save(employee2);

        // When - Action or the behaviour that we are going test
        List<Employee> employees = this.repository.findAll();

        // Then - Verify the output
        assertThat(employees).isNotNull();
        assertThat(employees.size()).isEqualTo(2);
    }

    @DisplayName("Junit test for get employee by id operation")
    @Test
    void givenEmployee_whenFindById_thenReturnEmployeeObject() {
        // Given - Precondition or setup
        Employee employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Ramesh")
                .email("ramesh@mail.com")
                .build();

        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        Employee employeeDB = this.repository.findById(employee.getId()).get();

        // Then - Verify the output
        assertThat(employeeDB).isNotNull();
    }
}