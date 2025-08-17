package mylab.bank.entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100.0;
        deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, getBalance());
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 이자율: %.1f%%", interestRate);
    }
}