package com.bnt.CustomerApplication.service;

import java.util.List;
import java.util.Optional;

import com.bnt.CustomerApplication.model.Customer;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public  Customer updateCustomer(Customer customer);
 
    public List<Customer> getAllCustomer();
 
    public  Optional<Customer> getCustomerById(long id);
 
    public void  deleteCustomer(long id);
 

}
