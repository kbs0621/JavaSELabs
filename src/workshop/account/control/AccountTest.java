package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {

	public static void main(String[] args) {
		// Account 객체 생성
		Account account = new Account();
		
		
		//1-1. setter 매서드 호출로 값을  대입
		//고객번호 : "A1100", 계좌번호 : "221-22-3477", 잔액 : 1000
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(1000);
		
		
		//1-2. Account 객체 생성 - 오버로딩(Overloading)된 생성자 호출
		System.out.println("고객번호 = " + account.getCustId());	
		System.out.println("계좌번호 = " + account.getAcctId());	
		System.out.println("잔액 = " + account.getBalance());
		
		//2.Account 객체 생성 - 오버로딩된 생성자 호출
		
		Account account2 = new Account("B1200", "331-22-3477", 2000);

		System.out.println("고객번호 = " + account2.getCustId());
		System.out.println("계좌번호 = " + account2.getAcctId());
		System.out.println("잔액 = " + account2.getBalance());
		
		
		System.out.println("10000원 입금");
		account2.deposit(10000);
		System.out.println("잔액  = " + account2.getBalance() + "원");
		
		System.out.println("10000원 출금");
		account2.withdraw(10000);
		System.out.println("잔액  = " + account2.getBalance() + "원");
		
		account2.withdraw(5000);
		System.out.println("잔액  = " + account2.getBalance());
		
	}

}
