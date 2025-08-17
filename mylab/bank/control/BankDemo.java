package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        try {
            System.out.println("=== 계좌 생성 ===");
            Bank bank = new Bank();
            String acc1 = bank.createSavingsAccount("홍길동", 10000, 3.0);
            String acc2 = bank.createCheckingAccount("김철수", 20000, 5000);
            String acc3 = bank.createSavingsAccount("이영희", 30000, 2.0);

            System.out.println("\n=== 모든 계좌 목록 ===");
            bank.printAllAccounts();

            System.out.println("\n=== 입금/출금 테스트 ===");
            bank.deposit(acc1, 5000);
            bank.withdraw(acc2, 3000);

            System.out.println("\n=== 이자 적용 테스트 ===");
            ((SavingsAccount) bank.findAccount(acc1)).applyInterest();

            System.out.println("\n=== 계좌 이체 테스트 ===");
            bank.transfer(acc3, acc2, 5000);

            System.out.println("\n=== 모든 계좌 목록 ===");
            bank.printAllAccounts();

            // 예외 발생 테스트
            bank.withdraw(acc2, 6000);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("예외 발생: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
        	System.out.println("예외 발생 : "+ e.getMessage());
        } catch (AccountNotFoundException e) {
        	System.out.println("예외 발생 : "+ e.getMessage());
        }

        try {
            Bank bank = new Bank();
            bank.withdraw("AC9999", 1000);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}