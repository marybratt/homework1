
public class CheckingAccount extends BankAccount {
	int limit = 10000;
	private int account;
	private int balance;
	
	public CheckingAccount() {
		this.account = 252525;
		this.balance = 10000;
		System.out.println("Checking Account account # is: " + this.account);
		System.out.println("Checking Account balance is: " + this.balance);
}
	
	
}
