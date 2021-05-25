package homework.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestSingleton {

	Server server1 = null;
	Server server2 = null;

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
	public void TestSingleton() {
		server1 = Server.getInstance();
		server2 = Server.getInstance();
		Assert.assertEquals("These 2 objects are the same", server1, server2);
	}
	
	@Test
	public void TestDisonnect() {
		server1 = Server.getInstance();
		server1.disconnect();
		assertEquals(server1.disconnect(), true);
	}
}
