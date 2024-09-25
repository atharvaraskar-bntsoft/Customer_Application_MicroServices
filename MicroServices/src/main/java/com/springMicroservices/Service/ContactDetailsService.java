package com.springMicroservices.Service;

import com.springMicroservices.Model.ContactDetails;

public interface ContactDetailsService {
    public ContactDetails getContactByCustomer(Long customerId);
    public ContactDetails addCustomerDetails(Long customerId , ContactDetails contactDeatils);
}
