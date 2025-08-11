package mylab.bank.entity;

import mylab.bank.exception.*;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000; // 예시처럼 AC1000부터 시작
    }

    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        accounts.add(new SavingsAccount(accNum, ownerName, balance, interestRate));
        System.out.printf("Saving(저축) 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%%n",
                accNum, ownerName, balance, interestRate);
        return accNum;
    }

    public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accNum = "AC" + nextAccountNumber++;
        accounts.add(new CheckingAccount(accNum, ownerName, balance, withdrawalLimit));
        System.out.printf("체킹 계좌가 생성되었습니다: 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원%n",
                accNum, ownerName, balance, withdrawalLimit);
        return accNum;
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() ->
                        new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
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
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccount, toAccount);
    }

    public void printAllAccounts() {
        accounts.forEach(acc -> System.out.println(acc.toString()));
        System.out.println("===================");
    }
}