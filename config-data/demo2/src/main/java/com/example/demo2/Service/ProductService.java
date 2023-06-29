package com.example.demo2.Service;

import java.util.List;

import com.example.demo2.Entity.Category;
import com.example.demo2.Entity.Product;

public interface ProductService {
    public List<Product> listAllProducts();
    public Product getProductById(Long id);
    public Product createProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
    public List<Product> findByCategory(Category category);
    public Product updateStock(Long id,Double quantity);
}
