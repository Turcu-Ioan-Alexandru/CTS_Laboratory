package decorator;

public abstract class BaseDecorator extends Partner{
	Partner part = null;
	
	public BaseDecorator(Partner partner) {
		super(partner.partnerCode, partner.partnerName);
		this.part = partner;
	}
	
	@Override
	public void addType(String type) 
	{
		System.out.println("Type cannot be processed");
	}
	
	@Override
	public void addFunds(double amount) {
		System.out.println("Funds unavailable");
	}
	
	@Override
	public void makePayment(double amount) {
		System.out.println("Payment cannot be processed");
	}
}
