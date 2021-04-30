package simple_factory;

public class TestFactory {

	public static void main(String[] args) {
		AbstractPartner partener1 = PartnerFactory.createPartner(PartnerType.CLIENT, "CLNT1", "Client1");
		AbstractPartner partener2 = PartnerFactory.createPartner(PartnerType.SUPPLIER, "SPLR1", "Supplier1");
		AbstractPartner partener3 = PartnerFactory.createPartner(PartnerType.BOTH, "BOTH1", "Both1");
		
		partener1.createDocument();
		partener2.createDocument();
		partener3.createDocument();

		System.out.println(partener1.getClass());
		System.out.println(partener2.getClass());
		System.out.println(partener3.getClass());
	}

}
