package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Role;
import com.driagon.springdatajpa.ecommerce.app.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyUnidirectionalTest {

    @Autowired
    private IUserRepository userRepository;

    @Test
    void saveUserMethod() {
        User user = new User();
        user.setFistName("Ramesh");
        user.setLastName("Fadatare");
        user.setEmail("ranmesh@mail.com");
        user.setPassword("secrete");

        Role admin = new Role();
        admin.setName("ROLE_ADMIN");

        Role customer = new Role();
        customer.setName("ROLE_CUSTOMER");

        user.getRoles().add(admin);
        user.getRoles().add(customer);

        this.userRepository.save(user);
    }

    @Test
    void updateUserMethod() {

        User user = this.userRepository.findById(1L).get();
        user.setFistName("Ram");
        user.setEmail("ram@mail.com");

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");

        user.getRoles().add(roleUser);

        this.userRepository.save(user);
    }

    @Test
    void fetchUserMethod() {
        User user = this.userRepository.findById(1L).get();
        System.out.println(user.getEmail());
        user.getRoles().forEach(r -> {
            System.out.println(r.getName());
        });
    }

    @Test
    void deleteUserMethod() {
        this.userRepository.deleteById(1L);
    }
}