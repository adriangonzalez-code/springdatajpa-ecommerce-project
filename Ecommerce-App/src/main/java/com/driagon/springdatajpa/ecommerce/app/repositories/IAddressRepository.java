package com.driagon.springdatajpa.ecommerce.app.repositories;

import com.driagon.springdatajpa.ecommerce.app.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}