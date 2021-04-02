package assignment;

public enum AccountType {
	STANDARD(0), BUDGET(1), PREMIUM(2), SUPER_PREMIUM(3);
	
	private final int accountType;
	
	private AccountType(int type) {
		this.accountType = type;
	}
	
	public int getType() {
		return this.accountType;
	}
}
