package com.springMicroservices.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springMicroservices.Model.AddressDetails;
import com.springMicroservices.Service.AddressDetailsServiceImpl;

@RestController
@RequestMapping("/address")
public class AddressDetailsController {
    
    @Autowired
    private AddressDetailsServiceImpl addressDetailsService;

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<AddressDetails> addAddressDetails(@PathVariable("customerId") Long customerId, @RequestBody AddressDetails addressDetails){
        AddressDetails addressFields = addressDetailsService.addAddressDetails(customerId, addressDetails);
        return ResponseEntity.ok().body(addressFields);
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<AddressDetails> getAddressDetailsByCustomerId(@PathVariable("customerId") long customerId){
      AddressDetails addressDetails = addressDetailsService.getAddressByCustomer(customerId);
      return ResponseEntity.ok().body(addressDetails);
    }

    }


