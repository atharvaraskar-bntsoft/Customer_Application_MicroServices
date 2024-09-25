package com.springMicroservices.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMicroservices.Model.ContactDetails;
import com.springMicroservices.Repository.ContactDetailsRepository;


@Service
public class ContactDetailsServiceimpl implements ContactDetailsService{

    @Autowired
     ContactDetailsRepository contactDetailsRepository;

    @Override
    public ContactDetails getContactByCustomer(Long customerId) {
      ContactDetails contactDetails2 = contactDetailsRepository.findByCustomerId(customerId);
      return contactDetails2;
    }

    @Override
    public ContactDetails addCustomerDetails(Long customerId ,ContactDetails contactDeatils) {
      contactDeatils.setCustomerId(customerId);
      ContactDetails contactDetails2 = contactDetailsRepository.save(contactDeatils);
      return contactDetails2;
    }
}
