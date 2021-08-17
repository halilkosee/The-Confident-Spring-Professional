package com.halilkose.myfancypdfinvoices.service;

import com.halilkose.myfancypdfinvoices.context.Application;
import com.halilkose.myfancypdfinvoices.model.Invoice;
import com.halilkose.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>(); //

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {

        User user = new Application().userService.findById(userId);
        if (user == null){
            throw  new IllegalStateException();
        }

        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }
}
