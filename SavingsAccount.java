
public class SavingsAccount extends BankAccount {
	int limit;
	private int account;
	private int balance;
	
	public SavingsAccount() {
		this.account = 363636;
		this.balance = 15000;
		System.out.println("Savings Account account # is: " + this.account);
		System.out.println("Savings Account balance is: " + this.balance);
}
}
