package assignment;

public class Account implements RateInterface{
	public double loanValue, rate;	
	public int	daysActive;
	public AccountType accountType;
	
	public void printLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
	}
	
	public double getLoan() {
		return this.loanValue;
	}
	
	public double getRate() {
		return this.rate;
	}
	
	public void printRate() {
		System.out.println("The rate is "+ this.rate);
	}
	
	//must have method - the lead has requested it in all classes
	@Override
	public double calculateMonthlyRate() {
		return loanValue*rate;
	}
	
	public double getMonthlyRate() {
		return this.calculateMonthlyRate();
	}
	
	public void setValue(double value) throws AmountException {
		if(value < 0)
			throw new AmountException();
		else
		{
			loanValue = value;
		}
	}
	
	public void print() {
		System.out.println("This is an account");
	}

	@Override
	public String toString() {
		return "Account [loanValue=" + loanValue + ", rate=" + rate + ", daysActive=" + daysActive + ", accountType="
				+ accountType + "]";
	}

	public static double calculate(Account[] accounts) {
	double totalFee = 0.0;
	Account	account;
	double brokerFee = 1.25;
	for	(int i = 0; i < accounts.length; i++) {
	account = accounts[i];
	if(account.accountType==AccountType.PREMIUM || account.accountType==AccountType.SUPER_PREMIUM)	
	totalFee+= brokerFee / 100 * (	
			account.loanValue*Math.pow(account.rate,(account.daysActive/365)) - account.loanValue);	
	}
	return	totalFee;
	}

	public Account(double value, double rate, AccountType accountType) throws AmountException {
		if(value < 0)
			throw new AmountException();
		else {
			this.loanValue = value;
		}
		this.rate = rate;
		this.accountType = accountType;
	}
	
	private Account() {
		
	}
}