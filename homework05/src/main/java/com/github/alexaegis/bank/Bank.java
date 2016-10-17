package com.github.alexaegis.bank;

import com.github.alexaegis.bank.accounting.BankAccount;
import com.github.alexaegis.bank.accounting.NormalAccount;
import com.github.alexaegis.bank.accounting.exceptions.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts = new ArrayList<>();

    public Bank() {

    }

    public void depositToAccount(BankAccount bankAccount, int amount) {
        accounts.get(accounts.indexOf(bankAccount)).deposit(amount);
    }

    public void withdrawFromAccount(BankAccount bankAccount, int amount) throws InsufficientBalanceException {
        accounts.get(accounts.indexOf(bankAccount)).withdraw(amount);
    }

    public void addAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public void update() {
        accounts.forEach(bankAccount -> {
            bankAccount.update();
            if(bankAccount instanceof NormalAccount && bankAccount.getBalance() < 0) {
                bankAccount.show();
            }
        });
    }

    public void listMostChanged(int count) {
        accounts.stream().sorted((a, b) -> {
            if(a.getHistorySize() > b.getHistorySize()) {
                return -1;
            } else if(a.getHistorySize() < b.getHistorySize()) {
                return 1;
            } else {
                return 0;
            }
        }).limit(count).sorted((a, b) -> {
            if(a.getBalance() > b.getBalance()) {
                return -1;
            } else if(a.getBalance() < b.getBalance()) {
                return 1;
            } else {
                return 0;
            }
        }).forEach(BankAccount::show);
    }

    public void listMostChangedFive() {
        listMostChanged(5);
    }
}