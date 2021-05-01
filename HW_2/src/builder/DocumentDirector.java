package builder;

public class DocumentDirector {
	Document.DocumentBuilder builder;
	
	public DocumentDirector(Document.DocumentBuilder builder) {
		this.builder = builder;
	}
	
	public Document createSalesInvoice() {
		return builder.addTotalValue(100).addVat(19).addNoVatVal().addDiscount(0).build();
	}
	
	public Document createSupplyInvoice() {
		return builder.addTotalValue(200).addVat(24).addNoVatVal().addDiscount(0).build();
	}
}
