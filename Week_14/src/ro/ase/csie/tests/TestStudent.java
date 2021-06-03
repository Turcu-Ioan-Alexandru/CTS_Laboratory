package ro.ase.csie.tests;

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

import ro.ase.csie.exceptions.WrongAgeException;
import ro.ase.csie.exceptions.WrongGradesException;
import ro.ase.csie.exceptions.WrongNameExceptions;

public class TestStudent {
	
	//test fixture
	static Student student = null;
	static ArrayList<Integer> grades = null;
	static int initialAge = 19;
	static String initialName = "John Doe";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
		grades = new ArrayList<>();
		grades.add(5);
		grades.add(9);	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		grades.clear();
		grades = null;
	}

	@Before
	public void setUp() throws Exception {
		student = new Student(initialName, initialAge, grades);
	}

	@After
	public void tearDown() throws Exception {
		student = null;
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
			assertEquals("Test for right value", newAge, student.getAge());
		} catch (WrongAgeException e) {
			fail("We got an exception for a right value");
		}
	}
	
	@Test
	public void testSetAgeErrorCondition() {
		int newAge  = initialAge * -1;
		try {
			student.setAge(newAge);
			fail("We didn't got an exception for a negative age");
		} catch (WrongAgeException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSetAgeErrorConditionGreaterThanMax() throws WrongAgeException {
		int newAge = Student.MAX_AGE + 1000;
		student.setAge(newAge);
	}
	
	@Test
	public void testGetGradesAverageAscendingOrder() throws WrongGradesException {
		ArrayList<Integer> sortedGrades = new ArrayList<>();
		sortedGrades.add(7);
		sortedGrades.add(8);
		sortedGrades.add(9);
		sortedGrades.add(10);
		student.setGrades(sortedGrades);
		
		float expectedAverage = 8.5f;
		float computedAverage = student.getGradesAverage();
	
		assertEquals(
				"Testing with an ascending sorted set of grades", expectedAverage, computedAverage,0);
		
	}
	
	@Test
	public void testGetGradesAverageCardinalityZero() throws WrongGradesException {
		ArrayList<Integer> grades = new ArrayList<>();
		student.setGrades(grades);
		
		float expectedAverage = 0;
		float computedAverage = student.getGradesAverage();
		
		assertEquals("Testing with an empty set of grades", expectedAverage, computedAverage, 0);
	}
	
	@Test
	public void testGetGradesAverageCardinalityOne() throws WrongGradesException {
		ArrayList<Integer> grades = new ArrayList<>();
		int theGrade = 10;
		grades.add(theGrade);
		
		student.setGrades(grades);
		
		float expectedAverage = theGrade;
		float computedAverage = student.getGradesAverage();
		
		assertEquals("Testing with one grade", expectedAverage, computedAverage, 0);
	}
	
}
