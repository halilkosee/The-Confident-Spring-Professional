package com.halilkose.myfancypdfinvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceDto {

    @JsonProperty("user_id")
    private String userId;
    private Integer amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
