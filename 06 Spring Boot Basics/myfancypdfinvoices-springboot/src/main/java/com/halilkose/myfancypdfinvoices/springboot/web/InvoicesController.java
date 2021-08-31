package com.halilkose.myfancypdfinvoices.springboot.web;

import com.halilkose.myfancypdfinvoices.springboot.dto.InvoiceDto;
import com.halilkose.myfancypdfinvoices.springboot.model.Invoice;
import com.halilkose.myfancypdfinvoices.springboot.service.InvoiceService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices(){
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody InvoiceDto invoiceDto){
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
