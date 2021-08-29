package com.halilkose.myfancypdfinvoices.web;

import com.halilkose.myfancypdfinvoices.model.Invoice;
import com.halilkose.myfancypdfinvoices.service.InvoiceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Validated
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices(){
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId,
                                 @RequestParam @Min(10) @Max(50) Integer amount) {
        return invoiceService.create(userId, amount);
    }
}
