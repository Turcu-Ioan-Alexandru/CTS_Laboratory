package decorator;

public class PartnerTypeDecorator extends BaseDecorator {
	
	public PartnerTypeDecorator(Partner partner) {
		super(partner);
	}
	
	@Override
	public void addType(String type) {
		System.out.println(this.part.partnerCode + " is a " + type);
	}
}
