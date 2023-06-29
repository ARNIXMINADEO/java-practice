package com.example.demo3.Service;

import java.util.List;

import com.example.demo3.Entity.Customer;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer getCustomerByNumberId(String numberId);
    public List<Customer> getCustomerByFirstname(String firstname);
    public List<Customer> getCustomerByLastname(String lastname);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(String numberId,Customer customer);
    public Customer deleteCustomer(String numberId);
}
