package com.halilkose.myfancypdfinvoices.web;
import com.halilkose.myfancypdfinvoices.dto.InvoiceDto;
import com.halilkose.myfancypdfinvoices.model.Invoice;
import com.halilkose.myfancypdfinvoices.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyFancyPdfInvoicesController {

    private final InvoiceService invoiceService;

    public MyFancyPdfInvoicesController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices(){
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody InvoiceDto invoiceDto){
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
