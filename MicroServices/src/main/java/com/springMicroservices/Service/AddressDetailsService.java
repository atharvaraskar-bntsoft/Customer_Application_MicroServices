package com.springMicroservices.Service;


import com.springMicroservices.Model.AddressDetails;


public interface AddressDetailsService {
    public AddressDetails getAddressByCustomer(Long customerId);
    public AddressDetails addAddressDetails(Long customerId , AddressDetails addressDetails);
}
