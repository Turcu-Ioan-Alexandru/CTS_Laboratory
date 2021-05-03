package decorator;

public abstract class Partner {
	protected String partnerCode;
	protected String partnerName;
	
	public void setPartnerCode(String code) {
		this.partnerCode = code;
	}
	
	public void setPartnerName(String name) {
		this.partnerName = name;
	}

	public Partner(String partnerCode, String partnerName) {
		super();
		this.partnerCode = partnerCode;
		this.partnerName = partnerName;
	}
	
	public abstract void addType(String type);
	public abstract void addFunds(double amount);
	public abstract void makePayment(double amount);
}
