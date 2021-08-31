package com.halilkose.myfancypdfinvoices.springboot.service;


import com.halilkose.myfancypdfinvoices.springboot.model.Invoice;
import com.halilkose.myfancypdfinvoices.springboot.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private final List<Invoice> invoices = new CopyOnWriteArrayList<>();
    private final UserService userService;
    private final String cdnUrl;

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void init(){
        System.out.println("Fetching PDF Template from S3...");
    }

    @PreDestroy
    public void shutdown(){
        System.out.println("Deleting downloaded templates...");
    }

    public List<Invoice> findAll(){
        return invoices;
    }

    public Invoice create(String userId, Integer amount){
        User user = userService.findById(userId);
        if (user == null){
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }
}
