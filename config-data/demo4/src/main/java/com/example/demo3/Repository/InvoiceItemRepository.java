package com.example.demo3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.Entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
    
}
