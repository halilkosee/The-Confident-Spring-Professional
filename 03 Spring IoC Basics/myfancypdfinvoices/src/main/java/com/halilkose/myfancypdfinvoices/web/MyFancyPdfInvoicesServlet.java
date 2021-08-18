package com.halilkose.myfancypdfinvoices.web;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.halilkose.myfancypdfinvoices.context.MyFancyPdfInvoicesApplicationConfiguration;
import com.halilkose.myfancypdfinvoices.model.Invoice;
import com.halilkose.myfancypdfinvoices.service.InvoiceService;
import com.halilkose.myfancypdfinvoices.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MyFancyPdfInvoicesServlet extends HttpServlet {

    private UserService userService;
    private ObjectMapper objectMapper;
    private InvoiceService invoiceService;

    @Override
    public void init() throws ServletException {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(MyFancyPdfInvoicesApplicationConfiguration.class);
        this.userService = ctx.getBean(UserService.class);
        this.objectMapper = ctx.getBean(ObjectMapper.class);
        this.invoiceService = ctx.getBean(InvoiceService.class);

        System.out.println(ctx.getBean(UserService.class));
        System.out.println(ctx.getBean(UserService.class));
        System.out.println(ctx.getBean(UserService.class));

        System.out.println(ctx.getBean(InvoiceService.class).getUserService());
        System.out.println(ctx.getBean(InvoiceService.class).getUserService());
        System.out.println(ctx.getBean(InvoiceService.class).getUserService());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/invoices")) {

            String userId = request.getParameter("user_id");
            Integer amount = Integer.valueOf(request.getParameter("amount"));

            Invoice invoice = invoiceService.create(userId, amount);

            response.setContentType("application/json; charset=UTF-8");
            String json = objectMapper.writeValueAsString(invoice);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    "<html>\n" +
                            "<body>\n" +
                            "<h1>Hello World</h1>\n" +
                            "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
                            "</body>\n" +
                            "</html>");
        } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Invoice> invoices = invoiceService.findAll();  //
            response.getWriter().print(objectMapper.writeValueAsString(invoices));  //
        }
    }
}