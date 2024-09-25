package com.bnt.CustomerApplication.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.CustomerApplication.model.Customer;
import com.bnt.CustomerApplication.service.CustomerService;

@RestController
@RequestMapping("/customerapi/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    Logger logger= LoggerFactory.getLogger(CustomerController.class);

       @PostMapping
       ResponseEntity<Customer>createVendor(@RequestBody Customer customer){
             logger.info("Creating new customer with data: {}", customer);
             Customer createdCustomer =customerService.saveCustomer(customer);
             logger.info("Created customer with ID: {}", customer.getId());
             return new ResponseEntity<Customer>(createdCustomer,HttpStatus.CREATED);
       }

      @GetMapping
      public ResponseEntity<List<Customer>> getAllVendors() {
             logger.info("Fetching all customers");
             List<Customer> listOfAllCustomers = customerService.getAllCustomer();
             logger.info("Fetched {} customer", listOfAllCustomers.size());
             return new ResponseEntity<>(listOfAllCustomers, HttpStatus.OK);
       }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getVendorById( @PathVariable("id") long id) {
           logger.info("Fetching customer with ID: {}", id);
            Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
            logger.info("Fetched customer: {}", optionalCustomer.get());
            return new ResponseEntity<>(optionalCustomer, HttpStatus.OK);   
    }

       @PutMapping
       ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
             logger.info("Updating Customer with ID: {}", customer.getId());
             Customer updatedCustomer = customerService.updateCustomer(customer);
             logger.info("Updated Customer: {}", updatedCustomer);
             return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK); 
       }

       @DeleteMapping("/{id}")
       ResponseEntity<String> deleteCustomer(@PathVariable("id")long id){
        logger.info("Deleting Customer with ID: {}", id);
        customerService.deleteCustomer(id);
        logger.info("Deleted Customer with ID: {}", id);
        return new ResponseEntity<>("Customer Deleted Successfully",HttpStatus.OK);

       }

}
