package simple_factory;

public class Both extends AbstractPartner{
	public double balance;
	public int availableStock;	
	
	public Both(double balance, int stock) {
		this.balance = balance;
		this.availableStock = stock;
	}

	@Override
	public void createDocument() {
		System.out.println("This document belongs to a partner that is both a client and a supplier");
	}
}
