package builder;

public class Document {
	 protected String documentDate;
	 protected String partnerCode;
	 protected int internalNumber;
	 protected double totalValue;
	 protected int vat;
	 protected double noVatValue;
	 protected int discount;
	 
	 
	 
	 public String getDocumentDate() {
		return documentDate;
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

	private Document() {
		 
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
	 
	 public static class DocumentBuilder {
			private Document doc = null;
			
			public DocumentBuilder(String date, String partner, int internalNum)
			{
				doc = new Document();
				doc.documentDate = date;
				doc.partnerCode = partner;
				doc.internalNumber = internalNum;
			}
			
			public DocumentBuilder addTotalValue(double value) {
				doc.totalValue = value;
				return this;
			}
			
			public DocumentBuilder addVat(int vat) {
				doc.vat = vat;
				return this;
			}
			public DocumentBuilder addNoVatVal() {
				doc.noVatValue = doc.totalValue - doc.totalValue * doc.vat;
				return this;
			}
			public DocumentBuilder addDiscount(int discount) {
				doc.discount = discount;
				return this;
			}
			
			public Document build() {
				return this.doc;
			}
			
			
	 }
}

