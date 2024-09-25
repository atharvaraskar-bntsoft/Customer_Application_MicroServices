package com.springMicroservices.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springMicroservices.Model.AddressDetails;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails , Long>{
    public AddressDetails findByCustomerId(Long customerId);
}
