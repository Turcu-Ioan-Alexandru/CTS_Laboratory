package builder;

import builder.Document.DocumentBuilder;

public class TestBuilder {

	public static void main(String[] args) {
		Document doc1 = new Document.DocumentBuilder("1.05.2021", "PRTNR1", 101).addDiscount(0).addTotalValue(1000).addVat(19).addNoVatVal().build();
		DocumentDirector dir = new DocumentDirector(new DocumentBuilder("2.05.2021", "PRTNR2", 102));
	}

}
