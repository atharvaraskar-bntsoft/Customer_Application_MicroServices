package com.bnt.CustomerApplication.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bnt.CustomerApplication.model.ContactDetails;

@FeignClient(name = "contact-service", url ="http://172.31.2.11:9001/contact")
public interface ContactService {

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<ContactDetails> addContactDetails(@PathVariable("customerId") Long customerId , @RequestBody ContactDetails contactDetails);
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ContactDetails> getContactDetailsByCustomerId(@PathVariable("customerId") long customerId);
      
}
