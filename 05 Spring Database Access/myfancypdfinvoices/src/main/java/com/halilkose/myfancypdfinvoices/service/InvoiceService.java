package com.halilkose.myfancypdfinvoices.service;

import com.halilkose.myfancypdfinvoices.model.Invoice;
import com.halilkose.myfancypdfinvoices.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InvoiceService {

    private List<Invoice> invoices = new CopyOnWriteArrayList<>();


    private final UserService userService;
    private final String cdnUrl;

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
    }

    @PostConstruct
    public void init(){
        System.out.println("Fetching PDF Template from S3...");
        //TODO download from s4 and save locally
    }

    @PreDestroy
    public void shutDown(){
        System.out.println("Deleting downloaded templates...");
        //TODO actual deleting of PDFs
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        // TODO real pdf creation and storing it on network server
        Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }



}
