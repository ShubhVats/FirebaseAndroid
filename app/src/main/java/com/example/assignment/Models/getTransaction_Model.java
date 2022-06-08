package com.example.assignment.Models;

public class getTransaction_Model {
    Integer Amount;
    String Date;
    String email;
    String To_From;
    Integer TransactionID;


    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTo_From() {
        return To_From;
    }

    public void setTo_From(String to_From) {
        To_From = to_From;
    }

    public Integer getTransactionID() {
        return TransactionID;
    }

    public void setTransactionID(Integer transactionID) {
        TransactionID = transactionID;
    }
}
