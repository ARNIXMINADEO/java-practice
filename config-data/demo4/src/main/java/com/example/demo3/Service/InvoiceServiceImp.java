package com.example.demo3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo3.Entity.Invoice;
import com.example.demo3.Repository.InvoiceRepository;

@Service
public class InvoiceServiceImp implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoice() {
        // TODO Auto-generated method stub
        List<Invoice> listInvoice = invoiceRepository.findAll();
        return listInvoice;
    }

    @Override
    public Invoice getInvoiceByNumberId(String numberInvoice) {
        // TODO Auto-generated method stub
        Invoice invoice = invoiceRepository.findByNumberInvoice(numberInvoice);
        if(invoice == null){
            return null;
        }
        return invoice;
    }

    @Override
    public List<Invoice> getInvoiceByCustomerId(Long customerId) {
        // TODO Auto-generated method stub
        List<Invoice> customerListInvoice = invoiceRepository.findByCustomerId(customerId);
        if(customerListInvoice == null){
            return null;
        }
        return customerListInvoice;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        // TODO Auto-generated method stub
        Invoice newInvoice = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if(newInvoice != null){
            return newInvoice;
        }
        invoice.setState("CREATED");
        newInvoice = invoiceRepository.save(invoice);
        return newInvoice;
    }

    @Override
    public Invoice updateInvoice(String numberInvoice, Invoice invoice) {
        // TODO Auto-generated method stub
        Invoice updateInvoice = invoiceRepository.findByNumberInvoice(numberInvoice);
        if(updateInvoice == null){
            return null;
        }
        updateInvoice.setNumberInvoice(invoice.getNumberInvoice());
        updateInvoice.setDescription(invoice.getDescription());

        return updateInvoice;
    }

    @Override
    public Invoice deleteInvoice(String numberInvoice) {
        // TODO Auto-generated method stub
        Invoice deleteInvoice = invoiceRepository.findByNumberInvoice(numberInvoice);
        if(deleteInvoice == null){
            return null;
        }
        deleteInvoice.setState("DELETED");
        return deleteInvoice;
    }
    
}
