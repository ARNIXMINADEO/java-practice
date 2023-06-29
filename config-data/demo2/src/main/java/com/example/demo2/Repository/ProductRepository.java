package com.example.demo2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.Entity.Category;
import com.example.demo2.Entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
    public List<Product> findByCategory(Category category);
    // public List<Product> findByName(String name);
    // public List<Product> findByState(Double state);
    // public List<Product> findByPrice(Double price);
}
