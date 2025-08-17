package mylab.bank.entity;

import mylab.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000; // ����ó�� AC1000���� ����
    }

    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        accounts.add(new SavingsAccount(accNum, ownerName, balance, interestRate));
        System.out.printf("Saving(����) ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ������: %.1f%%%n",
                accNum, ownerName, balance, interestRate);
        return accNum;
    }

    public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accNum = "AC" + nextAccountNumber++;
        accounts.add(new CheckingAccount(accNum, ownerName, balance, withdrawalLimit));
        System.out.printf("üŷ ���°� �����Ǿ����ϴ�: ���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��, ��� �ѵ�: %.1f��%n",
                accNum, ownerName, balance, withdrawalLimit);
        return accNum;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() ->
                        new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."));
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccount, toAccount);
    }

    public void printAllAccounts() {
        accounts.forEach(acc -> System.out.println(acc.toString()));
        System.out.println("===================");
    }
}