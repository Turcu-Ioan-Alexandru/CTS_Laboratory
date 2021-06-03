package ro.ase.cts.g1094.testing.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ro.ase.cts.g1094.testing.exceptions.WrongAgeException;
import ro.ase.cts.g1094.testing.exceptions.WrongGradesException;

class TestStudentNew {

	static Student student;
	static ArrayList<Integer> grades;
	static String initialName;
	static int initialAge;
	static int initialNoGrades;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		initialName = "John doe";
		initialAge = Student.MIN_AGE + 1;
		initialNoGrades = 3;
		grades = new ArrayList<>();
		
		Random random = new Random();
		
		for(int i = 0; i < initialNoGrades; i++) {
			grades.add(random.nextInt(Student.MAX_GRADE) + 1);
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student = new Student(initialName, initialAge, grades);
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
	public void testSetAgeMaxValue() throws WrongAgeException {
		int newAge = Integer.MAX_VALUE;
		student.setAge(newAge);
	}
	
	@Test
	public void testSetAgeBigValue() throws WrongAgeException {
		int newAge = 200;
		student.setAge(newAge);
	}
	
	@Test
	public void testSetAgeBoundaryLowLimit() throws WrongAgeException {
		int newAge = Student.MIN_AGE;
		student.setAge(newAge);
		assertEquals(newAge, student.getAge());
	}
	
	@Test
	public void testSetAgeBoundaryUpperLimit() throws WrongAgeException {
		int newAge = Student.MAX_AGE;
		student.setAge(newAge);
		assertEquals(newAge, student.getAge());
	}
	
	@Test
	public void testSetGradesReferenceCopy() throws WrongGradesException {
		int[] grades = new int[] {9, 9, 10};
		
		ArrayList<Integer> refGrades = (ArrayList<Integer>) Arrays.asList(9, 9, 10);
		
		for(int grade: grades) {
			
		}
		int[] studentGrades = new int[student.getNoGrades()];
		
		for(int i = 0; i < student.getNoGrades(); i++) {
			studentGrades[i] = student.getGrade(i);	
		}
		
		assertArrayEquals(grades, studentGrades);
	}
	
	@Test
	public void testGetGradesAveragePerformance() throws WrongGradesException {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		int noGrades = (int) 1e6;
		Random random = new Random();
		for(int i = 0; i < noGrades; i++) {
			grades.add(random.nextInt(Student.MAX_GRADE) + 1);
		}
		
		student.setGrades(grades);
		
		long tStart = System.currentTimeMillis();
		student.getGradesAverage();
		long tFinish = System.currentTimeMillis();
		long delta = tFinish - tStart;
		long performance = 20;
		if(delta <= performance) {
			assertTrue(true);
		} else {
			fail("Took to long");
		}
	}
	
	@Test
	public void testSetGradesPerformance2() {
		student.setGrades(performanceGrades);
		student.getGradesAverage();
	}
	
	@Test
	public void testGetMinCrossCheck() {
		
	}
	}
