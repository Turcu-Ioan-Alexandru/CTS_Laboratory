package ro.ase.csie.cts.homework3.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBuilder {

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
	public void TestDisconnect() {
		Server server1 = new Server.ServerBuilder("123.11.413", 501).addMaxConnections(50).addConnected(true).addDisconnected(false).build();
		server1.disconnect();
		assertEquals(server1.connected, false);
		assertEquals(server1.disconnected, true);
	}
	
	@Test
	public void TestBuild() {
		Server server2 = new Server.ServerBuilder("123.11.413", 501).addMaxConnections(50).addConnected(true).addDisconnected(false).build();
		assertEquals(server2.maxConnections, 50);
		assertEquals(server2.disconnected, false);
		assertEquals(server2.connected, true);
		assertEquals(server2.port, 501);
		assertEquals(server2.ipAddress, "123.11.413");
	}
}
