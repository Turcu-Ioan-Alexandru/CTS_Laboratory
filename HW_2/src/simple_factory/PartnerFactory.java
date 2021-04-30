package simple_factory;

public class PartnerFactory {
	public static AbstractPartner createPartner(PartnerType partnerType, String code, String name) {
		AbstractPartner partner = null;
		
		switch(partnerType) {
		case CLIENT:
			partner = new Client(1999.99);
			partner.setPartnerCode(code);
			partner.setPartnerName(name);
			break;
		case SUPPLIER:
			partner = new Supplier(100);
			partner.setPartnerCode(code);
			partner.setPartnerName(name);
			break;
		case BOTH:
			partner = new Both(999.99, 50);
			partner.setPartnerCode(code);
			partner.setPartnerName(name);
		default:
			
		}
		return partner;
	}
}
