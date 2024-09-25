package com.springMicroservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springMicroservices.Model.ContactDetails;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetails , Long>{
    public ContactDetails findByCustomerId(Long customerId);
}
