package prototype;

public class Document implements Cloneable{
	 protected String documentDate;
	 protected String partnerCode;
	 protected int internalNumber;
	 protected double totalValue;
	 protected int vat;
	 protected double noVatValue;
	 protected int discount;
	 
	 private Document() {
		 
	 }
	 
	 @Override
	 public Object clone() throws CloneNotSupportedException
	 {
		Document doc = new Document();
		doc.documentDate = this.documentDate;
		doc.partnerCode = this.partnerCode;
		doc.internalNumber = this.internalNumber;
		doc.discount = this.discount;
		doc.totalValue = this.totalValue;
		doc.vat = this.vat;
		doc.noVatValue = this.noVatValue;
		
		return doc;
	 }
	 
	 public Document(String documentDate, String partnerCode, int internalNumber, double totalValue, int vat,
				double noVatValue, int discount) {
			super();
			this.documentDate = documentDate;
			this.partnerCode = partnerCode;
			this.internalNumber = internalNumber;
			this.totalValue = totalValue;
			this.vat = vat;
			this.noVatValue = noVatValue;
			this.discount = discount;
		}

	public String getDocumentDate() {
		return  "This document was issued on " + documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public int getInternalNumber() {
		return internalNumber;
	}

	public void setInternalNumber(int internalNumber) {
		this.internalNumber = internalNumber;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public double getNoVatValue() {
		return noVatValue;
	}

	public void setNoVatValue(double noVatValue) {
		this.noVatValue = noVatValue;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	} 
}
