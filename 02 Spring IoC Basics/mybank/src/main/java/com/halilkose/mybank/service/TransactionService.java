package com.halilkose.mybank.service;

import com.halilkose.mybank.model.Transaction;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionService {

    private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(BigDecimal amount, String reference) {
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, timestamp, reference);
        transactions.add(transaction);
        return transaction;
    }

}