package com.example.demo3.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo3.Entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    
    public List<Invoice> findByCustomerId(Long customerId);

    public Invoice findByNumberInvoice(String numberInvoce);

}
