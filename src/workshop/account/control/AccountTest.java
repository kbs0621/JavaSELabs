package workshop.account.control;

import workshop.account.entity.Account;

public class AccountTest {

	public static void main(String[] args) {
		// Account °´Ã¼ »ý¼º
		Account account = new Account();
		
		//°í°´¹øÈ£ : "A1100", °èÁÂ¹øÈ£ : "221-22-3477", ÀÜ¾× : 100
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.setBalance(100);
		
		
	}

}
