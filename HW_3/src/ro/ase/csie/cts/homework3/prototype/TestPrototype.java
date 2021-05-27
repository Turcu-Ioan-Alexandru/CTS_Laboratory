package ro.ase.csie.cts.homework3.prototype;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPrototype {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Ignore
	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void TestPrototype() throws CloneNotSupportedException {
		ServerPrototype server1 = new ServerPrototype("143.122.222", 497, 100, true, false);
		ServerPrototype server2 = (ServerPrototype) server1.clone();
		assertEquals(server1.getIpAddress(), server2.getIpAddress());
	}
	
	@Test
	public void TestConnect() {
		ServerPrototype server3 = new ServerPrototype("143.122.222", 497, 100, false, true);
		server3.connect();
		assertEquals(server3.getConnectStatus(), true);
	}
}
