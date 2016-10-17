package com.github.alexaegis.bank.accounting;

enum Actions {

    WITHDRAW("Withdraw"),
    DEPOSIT("Deposit"),
    FAULTY_WITHDRAW("Withdraw"),
    FAULTY_DEPOSIT("Deposit");

    private String name;

    Actions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}