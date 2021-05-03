package decorator;

public class PaymentDecorator extends BaseDecorator {
	public PaymentDecorator(Partner partner) {
		super(partner);
	}
	
	@Override
	public void makePayment(double amount) {
		System.out.println(this.part.partnerCode + " made a " + amount + " dollars payment");
	}
}
