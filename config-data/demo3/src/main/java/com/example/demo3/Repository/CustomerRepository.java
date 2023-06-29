package com.example.demo3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.Entity.Customer;
import com.example.demo3.Entity.Region;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    public Customer findByNumberId(String numberId);
    public List<Customer> findByFirstname(String firstname);
    public List<Customer> findByLastname(String lastname);
    public List<Customer> findByRegion(Region region);
}
