package mylab.bank.control;

import mylab.bank.entity.*;
import mylab.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        try {
            System.out.println("=== ���� ���� ===");
            Bank bank = new Bank();
            String acc1 = bank.createSavingsAccount("ȫ�浿", 10000, 3.0);
            String acc2 = bank.createCheckingAccount("��ö��", 20000, 5000);
            String acc3 = bank.createSavingsAccount("�̿���", 30000, 2.0);

            System.out.println("\n=== ��� ���� ��� ===");
            bank.printAllAccounts();

            System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
            bank.deposit(acc1, 5000);
            bank.withdraw(acc2, 3000);

            System.out.println("\n=== ���� ���� �׽�Ʈ ===");
            ((SavingsAccount) bank.findAccount(acc1)).applyInterest();

            System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
            bank.transfer(acc3, acc2, 5000);

            System.out.println("\n=== ��� ���� ��� ===");
            bank.printAllAccounts();

            // ���� �߻� �׽�Ʈ
            bank.withdraw(acc2, 6000);
        } catch (WithdrawalLimitExceededException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
        	System.out.println("���� �߻� : "+ e.getMessage());
        } catch (AccountNotFoundException e) {
        	System.out.println("���� �߻� : "+ e.getMessage());
        }

        try {
            Bank bank = new Bank();
            bank.withdraw("AC9999", 1000);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}