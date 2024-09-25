package com.springMicroservices.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springMicroservices.Model.ContactDetails;
import com.springMicroservices.Service.ContactDetailsServiceimpl;

@RestController
@RequestMapping("/contact")
public class ContactDetailsCotroller {

    @Autowired
    private ContactDetailsServiceimpl contactDetailsService;
    

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<ContactDetails> addContactDetails(@PathVariable("customerId") Long customerId , @RequestBody ContactDetails contactDetails){
        ContactDetails contactFields = contactDetailsService.addCustomerDetails(customerId, contactDetails);
        return ResponseEntity.ok().body(contactFields);

    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<ContactDetails> getContactDetailsByCustomerId(@PathVariable("customerId") long customerId){
        ContactDetails contactDetails = contactDetailsService.getContactByCustomer(customerId);
        return ResponseEntity.ok().body(contactDetails);
    }
}

