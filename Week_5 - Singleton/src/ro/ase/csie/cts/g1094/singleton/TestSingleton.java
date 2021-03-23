package ro.ase.csie.cts.g1094.singleton;

public class TestSingleton {

	public static void main(String[] args) {
		DbConnection con1 = DbConnection.getConnection("127.0.0.1:1443", "cts");
		//DbConnection con2 = DbConnection.getConnection();
	}
}
