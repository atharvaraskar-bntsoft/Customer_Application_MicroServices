package com.bnt.CustomerApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnt.CustomerApplication.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long>{
    Optional<Customer> findByCustomerName(String userName);
}
