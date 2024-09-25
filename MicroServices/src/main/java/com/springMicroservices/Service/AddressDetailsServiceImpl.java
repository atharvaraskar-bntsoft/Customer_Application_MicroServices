package com.springMicroservices.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMicroservices.Model.AddressDetails;
import com.springMicroservices.Repository.AddressDetailsRepository;

@Service
public class AddressDetailsServiceImpl implements AddressDetailsService{

    @Autowired
    AddressDetailsRepository addressDetailsRepository;

    @Override
    public AddressDetails getAddressByCustomer(Long customerId) {
       AddressDetails addressDetails2 = addressDetailsRepository.findByCustomerId(customerId);
       return addressDetails2;
    }

    @Override
    public AddressDetails addAddressDetails(Long customerId , AddressDetails addressDetails) {  
        addressDetails.setCustomerId(customerId);    
        AddressDetails addressDetails2 = addressDetailsRepository.save(addressDetails);
        return addressDetails2;
    }
    
}

