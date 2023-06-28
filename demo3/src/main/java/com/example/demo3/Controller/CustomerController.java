package com.example.demo3.Controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.demo3.Entity.Customer;
import com.example.demo3.Service.CustomerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> customersList(){
        List<Customer> customers = new ArrayList<>();
        customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
        Customer customerDB = customerService.getCustomerByNumberId(customer.getNumberId());
        if(customerDB != null){
            return ResponseEntity.notFound().build();
        }
        customer.setState("CREATED");
        System.out.println(customer);
        customerDB = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDB);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerByNumberId(@PathVariable("id") String id){
        Customer customerDB = customerService.getCustomerByNumberId(id);
        if(customerDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") String id){
        Customer customerDB = customerService.getCustomerByNumberId(id);
        if(customerDB == null){
            return ResponseEntity.notFound().build();
        }
        customerDB = customerService.deleteCustomer(id);
        return ResponseEntity.ok(customerDB);
    }

    @PutMapping(value = "/{id}")
     public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") String id, @RequestBody Customer customer ){
        Customer customerDB = customerService.getCustomerByNumberId(id);
        if(customerDB == null){
            return ResponseEntity.notFound().build();
        }
        customerDB = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(customerDB);
    }
    
}
