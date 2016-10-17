package com.github.alexaegis.bank.accounting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Entry {

    private Actions action;
    private double amount;
    private Date date;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Entry(Actions action, double amount, Date date) {
        this.action = action;
        this.amount = amount;
        this.date = date;
    }

    public Actions getAction() {
        return action;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String dateAsString() {
        return dateFormat.format(date);
    }

    public void writeDate() {
        System.out.println(dateAsString());
    }
}