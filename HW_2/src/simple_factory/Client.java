package simple_factory;

public class Client extends AbstractPartner{
	double balance;
	
	public Client(double balance) {
		this.balance = balance;
	}

	@Override
	public void createDocument() {
		System.out.println("This document belongs to a client");
	}
	
	
}
