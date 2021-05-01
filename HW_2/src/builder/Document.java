package builder;

public class Document {
	 protected String documentDate;
	 protected String partnerCode;
	 protected int internalNumber;
	 protected double totalValue;
	 protected int vat;
	 protected double noVatValue;
	 protected int discount;
	 
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

