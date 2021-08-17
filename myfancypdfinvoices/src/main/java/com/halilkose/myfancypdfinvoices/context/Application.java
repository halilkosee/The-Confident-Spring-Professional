package com.halilkose.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halilkose.myfancypdfinvoices.service.InvoiceService;
import com.halilkose.myfancypdfinvoices.service.UserService;

public class Application {
    public static final InvoiceService invoiceService = new InvoiceService();
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final UserService userService = new UserService();

}
