package ro.ase.cts.g1094.testing.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ro.ase.cts.g1094.testing.exceptions.WrongAgeException;
import ro.ase.cts.g1094.testing.exceptions.WrongNameExceptions;
import ro.ase.cts.g1094.testing.models.Student;

public class TestStudent {

	static Student student = null;
	static ArrayList<Integer> grades = null;
	static int initialAge = 0;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<Integer> grades = new ArrayList<>();
		grades.add(5);
		grades.add(9);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetNameRightValue() throws WrongNameExceptions {
		String newName = "Alice";
		student.setName(newName);
		assertEquals("Testing with a right name", newName, student.getName());
	}

	@Test
	public void testSetAgeRightValue() {
		int newAge = initialAge + 1;
		try {
			student.setAge(newAge);
			assertEquals("Testing with a right name", newAge, student.getAge());
		}
		catch(WrongAgeException ex) {
			fail("Failed");
		}
	}
}
