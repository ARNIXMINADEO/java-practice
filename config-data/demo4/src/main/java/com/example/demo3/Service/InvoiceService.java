package com.example.demo3.Service;

import java.util.List;

import com.example.demo3.Entity.Invoice;

public interface InvoiceService {
    
    public List<Invoice> getAllInvoice();

    public Invoice getInvoiceByNumberId(String numberInvoice);

    public List<Invoice> getInvoiceByCustomerId(Long customerId);

    public Invoice createInvoice(Invoice invoice);

    public Invoice updateInvoice(String numberInvoice, Invoice invoice);

    public Invoice deleteInvoice(String numberInvoicResponseEntitye);
}
