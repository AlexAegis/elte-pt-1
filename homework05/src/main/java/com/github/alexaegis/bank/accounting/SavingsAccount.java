package com.github.alexaegis.bank.accounting;

public final class SavingsAccount extends BankAccount {

    private double interest = 0;

    public SavingsAccount(int accountNumber, double interest) {
        super(accountNumber);
        this.interest = interest;
    }

    @Override
    public void update() {
        deposit(balance * interest);
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

        SavingsAccount that = (SavingsAccount) o;

        return Double.compare(that.interest, interest) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(interest);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}