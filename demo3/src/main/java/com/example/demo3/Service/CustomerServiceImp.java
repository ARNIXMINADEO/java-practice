package com.example.demo3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.Entity.Customer;
import com.example.demo3.Repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByNumberId(String numberId) {
        // TODO Auto-generated method stub
        return customerRepository.findByNumberId(numberId);
    }

    @Override
    public List<Customer> getCustomerByFirstname(String firstname) {
        // TODO Auto-generated method stub
        return customerRepository.findByFirstname(firstname);
    }

    @Override
    public List<Customer> getCustomerByLastname(String lastname) {
        // TODO Auto-generated method stub
        return customerRepository.findByLastname(lastname);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // TODO Auto-generated method stub
        Customer customerDB = customerRepository.findByNumberId(customer.getNumberId());
        if(customerDB != null){
            return customerDB;
        }

        customer.setState("CREATED");
        customerDB = customerRepository.save(customer);
        return customerDB;
    }

    @Override
    public Customer updateCustomer(String numberId, Customer customer) {
        // TODO Auto-generated method stub
        Customer customerDB = customerRepository.findByNumberId(numberId);
        if(customerDB == null){
            return null;
        }
        customerDB.setFirstname(customer.getFirstname());
        customerDB.setLastname(customer.getLastname());
        customerDB.setEmail(customer.getEmail());
        customerDB.setPhotoUrl(customer.getPhotoUrl());

        return customerRepository.save(customerDB);
        
    }
    @Override
    public Customer deleteCustomer(String numberId) {
        // TODO Auto-generated method stub
    Customer customerDB = customerRepository.findByNumberId(numberId);
        if(customerDB == null){
            return null;
        }
        customerDB.setState("DELETED");
        return customerRepository.save(customerDB);
        
    }    
}
    

