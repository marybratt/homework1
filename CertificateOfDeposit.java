
public class CertificateOfDeposit extends BankAccount {
	int limit;
	private int account;
	private int balance;
	
	public CertificateOfDeposit() {
		this.account = 141414;
		this.balance = 2500;
		System.out.println("Certificate of Deposit account # is: " + this.account);
		System.out.println("Certificate of Deposit  balance is: " + this.balance);
}
}
