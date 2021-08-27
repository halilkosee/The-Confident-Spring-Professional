package com.halilkose.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halilkose.mybank.context.Application;
import com.halilkose.mybank.model.Transaction;
import com.halilkose.mybank.service.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class TransactionServlet extends HttpServlet {

    private TransactionService transactionService = Application.transactionService;
    private ObjectMapper objectMapper = Application.objectMapper;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {
            List<Transaction> transactions = transactionService.findAll();
            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().println(objectMapper.writeValueAsString(transactions));
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equalsIgnoreCase("/transactions")) {

            BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(req.getParameter("amount")));
            String reference = req.getParameter("reference");

            Transaction transaction = transactionService.create(amount, reference);

            resp.setContentType("application/json; charset=UTF-8");
            resp.getWriter().print(objectMapper.writeValueAsString(transaction));

        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}