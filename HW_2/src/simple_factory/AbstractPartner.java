package simple_factory;

public abstract class AbstractPartner {
	protected String partnerCode;
	protected String partnerName;
	
	public void setPartnerCode(String code) {
		this.partnerCode = code;
	}
	
	public void setPartnerName(String name) {
		this.partnerName = name;
	}
	
	public abstract void createDocument();
}
