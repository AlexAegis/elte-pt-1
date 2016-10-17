package com.github.alexaegis;

import com.github.alexaegis.bank.Bank;
import com.github.alexaegis.bank.accounting.BankAccount;
import com.github.alexaegis.bank.accounting.NormalAccount;
import com.github.alexaegis.bank.accounting.SavingsAccount;

public class Main {

    private static Bank bank = new Bank();

    private Main() {

    }

    public static void main(String[] args) throws Exception {

        BankAccount normalAccount1 = new NormalAccount(11, 50000);
        BankAccount normalAccount2 = new NormalAccount(12, 50000);
        BankAccount normalAccount3 = new NormalAccount(13, 50000);
        BankAccount savingsAccount1 = new SavingsAccount(21, 1.04);
        BankAccount savingsAccount2 = new SavingsAccount(22, 1.06);
        BankAccount savingsAccount3 = new SavingsAccount(23, 1.05);

        bank.addAccount(normalAccount1);
        bank.addAccount(normalAccount2);
        bank.addAccount(normalAccount3);
        bank.addAccount(savingsAccount1);
        bank.addAccount(savingsAccount2);
        bank.addAccount(savingsAccount3);

        bank.depositToAccount(normalAccount1, 2000);
        bank.depositToAccount(normalAccount1, 8000);
        bank.depositToAccount(normalAccount2, 10000);
        bank.depositToAccount(normalAccount2, 12000);
        bank.depositToAccount(normalAccount2, 10500);
        bank.depositToAccount(normalAccount3, 150);
        bank.depositToAccount(normalAccount3, 10);
        bank.depositToAccount(savingsAccount1, 400500);
        bank.depositToAccount(savingsAccount2, 200000);
        bank.depositToAccount(savingsAccount2, 220000);
        bank.depositToAccount(savingsAccount3, 500000);
        bank.depositToAccount(savingsAccount3, 506000);
        bank.depositToAccount(savingsAccount3, 520000);

        bank.withdrawFromAccount(savingsAccount3, 100000);
        bank.update();
        bank.withdrawFromAccount(savingsAccount3, 200000);
        bank.update();

        bank.listMostChangedFive();
    }
}