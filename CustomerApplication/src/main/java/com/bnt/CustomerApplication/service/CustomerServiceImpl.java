package com.bnt.CustomerApplication.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bnt.CustomerApplication.ExternalService.AddressService;
import com.bnt.CustomerApplication.ExternalService.ContactService;
import com.bnt.CustomerApplication.exception.DataIsNotPresentException;
import com.bnt.CustomerApplication.exception.DuplicateDataException;
import com.bnt.CustomerApplication.exception.IdNotFoundException;
import com.bnt.CustomerApplication.model.AddressDetails;
import com.bnt.CustomerApplication.model.ContactDetails;
import com.bnt.CustomerApplication.model.Customer;
import com.bnt.CustomerApplication.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    ContactService contactService;

    @Override
    public Customer saveCustomer(Customer customer) {
        logger.info("Saving customer: {}", customer);
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerName(customer.getCustomerName()); 
        if (optionalCustomer.isPresent()) {
            logger.warn("Duplicate customer name detected: {}", customer.getCustomerName());
            throw new DuplicateDataException("Customer is already present");
        }
        
        Customer savedCustomer = customerRepository.save(customer);
        logger.info("Saved customer with ID: {}", savedCustomer.getId());

        ResponseEntity<AddressDetails> savedAddressService = addressService.addAddressDetails(
                savedCustomer.getId(), savedCustomer.getAddressDetails());
        
        ResponseEntity<ContactDetails> savedContactService = contactService.addContactDetails(
                savedCustomer.getId(), savedCustomer.getContactaDetails());        
                     
        savedCustomer.setAddressDetails(savedAddressService.getBody());
        savedCustomer.setContactaDetails(savedContactService.getBody());

        return savedCustomer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        logger.info("Updating customer with ID: {}", customer.getId());
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
        if (!optionalCustomer.isPresent()) {
            logger.warn("Customer not found with ID: {}", customer.getId());
            throw new IdNotFoundException("Customer not found with ID: " + customer.getId());
        }
        Customer updatedCustomer = customerRepository.save(customer);
        logger.info("Updated customer: {}", updatedCustomer);
        return updatedCustomer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        logger.info("Fetching all customers");
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            logger.warn("No customers found");
            throw new DataIsNotPresentException("No customers found");
        }
        logger.info("Fetched {} customers", customers.size());
        return customers;
    }

    @Override
    public Optional<Customer> getCustomerById(long id) {
        logger.info("Fetching customer with ID: {}", id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            logger.warn("Customer not found with ID: {}", id);
            throw new IdNotFoundException("Customer not found with ID: " + id);
        }
        logger.info("Fetched customer: {}", optionalCustomer.get());
        ResponseEntity<AddressDetails> addressResponse = addressService.getAddressDetailsByCustomerId(id);
        optionalCustomer.get().setAddressDetails(addressResponse.getBody());

        ResponseEntity<ContactDetails> contactResponse = contactService.getContactDetailsByCustomerId(id);
        optionalCustomer.get().setContactaDetails(contactResponse.getBody());
        
        return optionalCustomer;
    }

    @Override
    public void deleteCustomer(long id) {
        logger.info("Deleting customer with ID: {}", id);
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()) {
            logger.warn("Customer not found with ID: {}", id);
            throw new IdNotFoundException("Customer not found with ID: " + id);
        }
        customerRepository.deleteById(id);
        logger.info("Deleted customer with ID: {}", id);
    }

}
