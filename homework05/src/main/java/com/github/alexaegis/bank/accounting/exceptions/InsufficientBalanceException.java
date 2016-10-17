package com.github.alexaegis.bank.accounting.exceptions;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String message) {
        super(message);
    }

}
