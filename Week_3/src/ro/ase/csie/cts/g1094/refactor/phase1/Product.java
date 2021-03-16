package ro.ase.csie.cts.g1094.refactor.phase1;

import ro.ase.csie.acs.cts.g1094.phase3.services.Marketing2021Strategy;
import ro.ase.csie.acs.cts.g1094.phase3.services.ValidatorService;
import ro.ase.csie.acs.cts.refactor.exceptions.InvalidAgeException;
import ro.ase.csie.acs.cts.refactor.exceptions.InvalidPriceException;
import ro.ase.csie.cts.g1094.refactor.phase3.MarketingServiceInterface;

public class Product {
	
	MarketingServiceInterface mkService = null;
	ValidatorService validator = null;
	public Product(MarketingServiceInterface service, ValidatorService serv) {
		
	}
	public static float getDiscountValue(float price, float discount) {
		return discount * price;
	}

	public float computePriceWithDiscount(ProductType productType, float price, int accountAge) throws InvalidPriceException, InvalidAgeException
	  {
		if(price <= 0) {
			throw new InvalidPriceException();
		}
		if(accountAge <= 0) {
			throw new InvalidAgeException();
		}
	    float finalPrice = 0;
	    //float fidelityDiscount = (accountAge > MAX_AGE_ACCOUNT) ? MAX_FIDELITY_DISCOUNT : (float)accountAge/100; 
	    float discountValue;
	    switch(productType) {
	    case NEW:
	    	finalPrice = price;
	    	break;
	    case DISCOUNTED:
	    	discountValue = getDiscountValue(price, ProductType.DISCOUNTED.getDiscount());
	    	finalPrice = (price - (ProductType.DISCOUNTED.getDiscount() * price)) - mkService.getFidelityDiscount(accountAge) * (price - (ProductType.DISCOUNTED.getDiscount() * price));
	    	break;
	    case LIMITED_STOCK:
	    	discountValue = getDiscountValue(price, ProductType.LIMITED_STOCK.getDiscount());
	    	finalPrice = (price - (ProductType.LIMITED_STOCK.getDiscount() * price)) - mkService.getFidelityDiscount(accountAge) * (price - (ProductType.LIMITED_STOCK.getDiscount() * price));
	    	break;
	    case LEGACY:
	    	discountValue = getDiscountValue(price, ProductType.LEGACY.getDiscount());
	    	finalPrice = (price - (ProductType.LEGACY.getDiscount() * price)) - mkService.getFidelityDiscount(accountAge) * (price - (ProductType.LEGACY.getDiscount() * price));
	    	break;
	    default:
	    	throw new UnsupportedOperationException("The enum type is not covered");
	    	
	    }
	    return finalPrice;
	  }
}