package ro.ase.csie.acs.cts.g1094.phase3.test;

import ro.ase.csie.acs.cts.refactor.exceptions.InvalidAgeException;
import ro.ase.csie.acs.cts.refactor.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1094.refactor.phase1.Product;
import ro.ase.csie.cts.g1094.refactor.phase1.ProductType;

public class TestProduct {

	public static void main(String[] args) {
		Product product = new Product();
		try {
			float finalPrice = product.computePriceWithDiscount(ProductType.DISCOUNTED, 100, 5);
			System.out.println("The price is " + finalPrice);
		} catch (InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
