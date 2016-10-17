package com.github.alexaegis.bank.accounting;

import java.util.Date;

public final class NormalAccount extends BankAccount {

    private int overdraftLimit = 0;

    public NormalAccount(int accountNumber) {
        super(accountNumber);
    }

    public NormalAccount(int accountNumber, int overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount >= balance + overdraftLimit) {
            history.add(new Entry(Actions.WITHDRAW, amount, new Date()));
        } else {
            history.add(new Entry(Actions.FAULTY_WITHDRAW, amount, new Date()));
        }
        balance -= amount;
    }

    public void setOverdraftLimit(int overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        NormalAccount that = (NormalAccount) o;

        return overdraftLimit == that.overdraftLimit;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + overdraftLimit;
        return result;
    }
}