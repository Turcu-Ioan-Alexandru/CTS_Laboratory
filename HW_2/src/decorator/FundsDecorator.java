package decorator;

public class FundsDecorator extends BaseDecorator{
	public FundsDecorator(Partner partner) {
		super(partner);
	}
	
	@Override
	public void addFunds(double amount) {
		System.out.println(this.part.partnerCode + " has " + amount + " dollars in their account");
	}
}
