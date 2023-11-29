package com.driagon.springboot.testing.app.repositories;

import com.driagon.springboot.testing.app.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private IEmployeeRepository repository;

    private Employee employee;

    @BeforeEach
    void setup() {
        this.employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@mail.com")
                .build();
    }

    // Unit test for save employee operation
    @Test
    @DisplayName("JUnit test for save employee operation")
    void givenEmployee_whenSave_thenReturnSavedEmployee() {

        // Given - Precondition or setup

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

        Employee employee2 = Employee.builder()
                .firstName("John")
                .lastName("Cena")
                .email("john.cena@mail.com")
                .build();

        this.repository.save(employee);
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
        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        Employee employeeDB = this.repository.findById(employee.getId()).get();

        // Then - Verify the output
        assertThat(employeeDB).isNotNull();
    }

    @DisplayName("Junit test for get Employee by email operation")
    @Test
    void givenEmployeeEmail_whenFindByEmail_thenReturnEmployeeObject() {
        // Given - Precondition or setup
        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        Employee employeeDB = this.repository.findByEmail(employee.getEmail()).get();

        // Then - Verify the output
        assertThat(employeeDB).isNotNull();
    }

    @DisplayName("Junit test for update employee operation")
    @Test
    void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        // Given - Precondition or setup
        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        Employee savedEmployee = this.repository.findById(employee.getId()).get();
        savedEmployee.setEmail("ram@mail.com");
        savedEmployee.setFirstName("Ram");

        Employee updatedEmployee = this.repository.save(savedEmployee);

        // Then - Verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("ram@mail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Ram");
    }

    @DisplayName("Junit test for delete Employee operation")
    @Test
    void givenEmployeeObject_whenDelete_thenRemoveEmployee() {
        // Given - Precondition or setup
        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        this.repository.delete(employee);

        Optional<Employee> employeeOptional = this.repository.findById(employee.getId());

        // Then - Verify the output
        assertThat(employeeOptional).isEmpty();
    }

    @DisplayName("Junit test for custom query using JPQL with index")
    @Test
    void givenFirstNameAndLastName_whenFindByJPQL_thenReturnEmployeeObject() {
        // Given - Precondition or setup
        this.repository.save(employee);

        String firstName = "Ramesh";
        String lastName = "Fadatare";

        // When - Action or the behaviour that we are going test
        Employee savedEmployee = this.repository.findByJPQL(firstName, lastName);

        // Then - Verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for custom query using JPQL with Named params")
    @Test
    void givenFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnEmployeeObject() {
        // Given - Precondition or setup
        this.repository.save(employee);

        String firstName = "Ramesh";
        String lastName = "Fadatare";

        // When - Action or the behaviour that we are going test
        Employee savedEmployee = this.repository.findByJPQLNamedParams(firstName, lastName);

        // Then - Verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for custom query using Native SQL with index")
    @Test
    void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnEmployeeObject() {
        // Given - Precondition or setup
        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        Employee savedEmployee = this.repository.findByNativeSQL(employee.getFirstName(), employee.getLastName());

        // Then - Verify the output
        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("Junit test for custom query using Native SQL with named params")
    @Test
    void givenFirstNameAndLastName_whenFindByNativeSQLNamedParams_thenReturnEmployeeObject() {
        // Given - Precondition or setup
        this.repository.save(employee);

        // When - Action or the behaviour that we are going test
        Employee savedEmployee = this.repository.findByNativeSQLNamed(employee.getFirstName(), employee.getLastName());

        // Then - Verify the output
        assertThat(savedEmployee).isNotNull();
    }
}