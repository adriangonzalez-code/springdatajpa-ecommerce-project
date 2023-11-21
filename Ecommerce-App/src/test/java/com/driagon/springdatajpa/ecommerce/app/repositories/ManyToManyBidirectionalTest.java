package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Role;
import com.driagon.springdatajpa.ecommerce.app.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalTest {

    @Autowired
    private IRoleRepository roleRepository;

    @Test
    void saveRoleMethod() {
        User user = new User();
        user.setFistName("Ramesh");
        user.setLastName("Fadatare");
        user.setEmail("ranmesh@mail.com");
        user.setPassword("secrete");

        User admin = new User();
        admin.setFistName("admin");
        admin.setLastName("admin");
        admin.setEmail("admin@mail.com");
        admin.setPassword("admin");

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");

        roleAdmin.getUsers().add(user);
        roleAdmin.getUsers().add(admin);

        user.getRoles().add(roleAdmin);
        admin.getRoles().add(roleAdmin);

        this.roleRepository.save(roleAdmin);
    }

    @Test
    void fetchRoleMethod() {
        List<Role> roles = this.roleRepository.findAll();
        roles.forEach(r -> {
            System.out.println(r.getName());
            r.getUsers().forEach(u -> {
                System.out.println(u.getFistName());
            });
        });
    }
}