package simple_factory;

public class Supplier extends AbstractPartner{
	int availableStock;
	
	public Supplier(int stock) {
		this.availableStock = stock;
	}

	@Override
	public void createDocument() {
		System.out.println("This document belongs to a supplier");
	}
}
