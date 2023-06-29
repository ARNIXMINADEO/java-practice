package com.example.demo3.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.NativeQuery.ReturnProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo3.Entity.Invoice;
import com.example.demo3.Service.InvoiceService;


@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    
    @Autowired
    InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        List<Invoice> invoicesList = new ArrayList<>();
        invoicesList = invoiceService.getAllInvoice();
        return ResponseEntity.ok(invoicesList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Invoice> getInvoice(@PathVariable("id") String numberId){
        Invoice invoice = invoiceService.getInvoiceByNumberId(numberId);
        if(invoice == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(invoice);
    }
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
        Invoice invoiceCreated = invoiceService.getInvoiceByNumberId(invoice.getNumberInvoice());
        if(invoiceCreated != null){
            return ResponseEntity.noContent().build();
        }
        invoiceCreated = invoiceService.createInvoice(invoice);
        return ResponseEntity.ok().body(invoiceCreated);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") String numberId,@RequestBody Invoice invoice){
        Invoice invoiceUpdated = invoiceService.getInvoiceByNumberId(numberId);
        if(invoiceUpdated == null){
            return ResponseEntity.noContent().build();
        }
        invoiceUpdated = invoiceService.updateInvoice(numberId,invoice);
        return ResponseEntity.ok().body(invoiceUpdated);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Invoice> deleteInvoice(@PathVariable("id") String numberId){
        Invoice invoiceDeleted = invoiceService.getInvoiceByNumberId(numberId);
        if(invoiceDeleted == null){
            return ResponseEntity.noContent().build();
        }
        invoiceDeleted = invoiceService.deleteInvoice(numberId);
        return ResponseEntity.ok().body(invoiceDeleted);
    }
}
