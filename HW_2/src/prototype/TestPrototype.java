package prototype;

public class TestPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {
		Document d1 = new Document("1.11.2020", "PRTNR1", 101, 5, 2000, 19, 1950);
		System.out.println(d1.getDocumentDate());
		Document d2 = (Document) d1.clone();
		System.out.println(d2.getDocumentDate());
	}

}
