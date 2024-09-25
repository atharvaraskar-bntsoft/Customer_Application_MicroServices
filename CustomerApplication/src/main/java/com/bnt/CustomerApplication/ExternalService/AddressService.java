package com.bnt.CustomerApplication.ExternalService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bnt.CustomerApplication.model.AddressDetails;

@FeignClient(name = "address-service", url ="http://172.31.2.11:9001/address")
public interface AddressService {

    @PostMapping("/customer/{customerId}")
  
    ResponseEntity<AddressDetails> addAddressDetails( @PathVariable("customerId") long customerId, @RequestBody AddressDetails addressDetails);

     @GetMapping("/customer/{customerId}")
    ResponseEntity<AddressDetails> getAddressDetailsByCustomerId(@PathVariable("customerId") long customerId);

}

   
