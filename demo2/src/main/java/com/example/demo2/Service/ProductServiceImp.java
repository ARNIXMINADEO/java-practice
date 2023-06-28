package com.example.demo2.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.Entity.Category;
import com.example.demo2.Entity.Product;
import com.example.demo2.Repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    
    private final ProductRepository productRepository;

    @Override
    public List<Product> listAllProducts() {
        // TODO Auto-generated method stub
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        // TODO Auto-generated method stub
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        // TODO Auto-generated method stub
        Product productDB = getProductById(product.getId());
        if(null == productDB){
            return null;
        }
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        productDB.setCategory(product.getCategory());

        return productRepository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        // TODO Auto-generated method stub
        Product productDB = getProductById(id);
        if(null == productDB){
            return null;
        }
        productDB.setStatus("DELETED");
        return productRepository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        // TODO Auto-generated method stub
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        // TODO Auto-generated method stub
        Product productDB = getProductById(id);
        if(null == productDB){
            return null;
        }
        productDB.setStock(productDB.getStock() + quantity);
        return productRepository.save(productDB);
    }
    
}
