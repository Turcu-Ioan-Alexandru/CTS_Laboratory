package decorator;

public class NonAbstractPartner extends Partner{

	public NonAbstractPartner(String code, String name) {
		super(code, name);
	}

	@Override
	public void addType(String type) {
		System.out.println("This partner is nonAbstract");
		
	}

	@Override
	public void addFunds(double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePayment(double amount) {
		// TODO Auto-generated method stub
		
	}
	
	
}
