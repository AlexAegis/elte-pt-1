package com.github.alexaegis.bank.accounting;

import com.github.alexaegis.bank.accounting.exceptions.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BankAccount {

    protected int accountNumber = 0;
    protected double balance = 0;
    protected List<Entry> history = new ArrayList<>();

    public BankAccount() {

    }

    public BankAccount(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if(amount <= balance) {
            history.add(new Entry(Actions.WITHDRAW, amount, new Date()));
            balance -= amount;
        } else {
            history.add(new Entry(Actions.FAULTY_WITHDRAW, amount, new Date()));
            throw new InsufficientBalanceException("There was not enough money on the account to fulfill the request");
        }
    }

    public void deposit(double amount) {
        history.add(new Entry(Actions.DEPOSIT, amount, new Date()));
        balance += amount;
    }

    public void update() {

    }

    public void modifyBalance(Actions action, int amount) throws InsufficientBalanceException {
        switch (action) {
            case WITHDRAW: withdraw(amount);
                break;
            case DEPOSIT: deposit(amount);
                break;
            default:
                break;
        }
    }

    public void show() {
        System.out.println(toString());
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Entry> getHistory() {
        return new ArrayList<>(history);
    }

    public int getHistorySize() {
        return history.size();
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BankAccount that = (BankAccount) o;

        if (accountNumber != that.accountNumber) {
            return false;
        }
        if (Double.compare(that.balance, balance) != 0) {
            return false;
        }
        return history != null ? history.equals(that.history) : that.history == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountNumber;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (history != null ? history.hashCode() : 0);
        return result;
    }
}