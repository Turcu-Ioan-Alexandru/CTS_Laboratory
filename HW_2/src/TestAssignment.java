import builder.Document;
import builder.DocumentDirector;
import decorator.BaseDecorator;
import decorator.FundsDecorator;
import decorator.NonAbstractPartner;
import decorator.Partner;
import decorator.PartnerTypeDecorator;
import decorator.PaymentDecorator;
import builder.Document.DocumentBuilder;
import simple_factory.AbstractPartner;
import simple_factory.PartnerFactory;
import simple_factory.PartnerType;

public class TestAssignment implements Cloneable{
	

	public static void main(String[] args) throws CloneNotSupportedException{
		
		System.out.println("---------------------------------------BUILDER--------------------------------------------------------");
		Document doc1 = new Document.DocumentBuilder("1.05.2021", "PRTNR1", 101).addDiscount(0).addTotalValue(1000).addVat(19).addNoVatVal().build();
		DocumentDirector dir = new DocumentDirector(new DocumentBuilder("2.05.2021", "PRTNR2", 102));
		
		System.out.println(doc1.getPartnerCode());
		dir.createSalesInvoice();
		
		System.out.println("---------------------------------------SIMPLE FACTORY---------------------------------------");
		
		AbstractPartner partener1 = PartnerFactory.createPartner(PartnerType.CLIENT, "CLNT1", "Client1");
		AbstractPartner partener2 = PartnerFactory.createPartner(PartnerType.SUPPLIER, "SPLR1", "Supplier1");
		AbstractPartner partener3 = PartnerFactory.createPartner(PartnerType.BOTH, "BOTH1", "Both1");
		
		partener1.createDocument();
		partener2.createDocument();
		partener3.createDocument();

		System.out.println(partener1.getClass());
		System.out.println(partener2.getClass());
		System.out.println(partener3.getClass());
		
		System.out.println("------------------------------------------DECORATOR-----------------------------------------------");
		
		Partner part100 = new NonAbstractPartner("Prtn100", "Partenerul nr. 100");
		part100.addType("...");
		part100.addFunds(0);
		part100.makePayment(0);
		part100 = new FundsDecorator(part100);
		part100.addFunds(199);
		part100 = new PartnerTypeDecorator(part100);
		part100.addType("Client");
		part100 = new PaymentDecorator(part100);
		part100.makePayment(50);

		
	}
}
