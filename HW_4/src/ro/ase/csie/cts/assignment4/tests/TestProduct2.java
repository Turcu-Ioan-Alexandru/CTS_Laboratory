package ro.ase.csie.cts.assignment4.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import ro.ase.csie.cts.assignment4.Product;
import ro.ase.csie.cts.assignment4.exceptions.WrongSoldItemsException;

public class TestProduct2 {

	static Product product;
	static String name = "Laptop";
	static float price = 100;
	static ArrayList<Integer> weeklySoldItems;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		weeklySoldItems = new ArrayList<>();
		weeklySoldItems.add(25);
		weeklySoldItems.add(50);
		weeklySoldItems.add(75);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		weeklySoldItems.clear();
		weeklySoldItems = null;
	}

	@Before
	public void setUp() throws Exception {
		product = new Product(name, price, weeklySoldItems);
	}

	@After
	public void tearDown() throws Exception {
		product = null;
	}

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testRightAddWeeks() {
		int newWeek = 49;
		product.addWeek(newWeek);
		
		assertEquals(newWeek, product.getSoldItems(product.getNoSales() - 1));
	}
	
	@Test
	public void testRightGetSoldItems() {
		int newWeekAdded = 89;
		int index = 2;
		
		product.getAllWeeks().add(index, newWeekAdded);
		
		assertEquals(newWeekAdded, product.getSoldItems(index));
	}
	
	@Test 
	public void testRightWeeksAboveLimit() {
		ArrayList<Integer> noCarsSold = new ArrayList<Integer>();
		noCarsSold.add(20);
		noCarsSold.add(44);
		noCarsSold.add(55);
		noCarsSold.add(90);
		Product newProd = new Product("Hyundai", 9999, noCarsSold);
		assertEquals(2, newProd.getNoWeeksAboveLimit(50));
	}
	
	@Test 
	public void testCardinalityWeeksAboveLimitZero() throws WrongSoldItemsException{
		ArrayList<Integer> noProductsSold = new ArrayList<Integer>();
		product.setSales(noProductsSold);
		
		int expectedSalesAboveLimit = 0;
		int actualSalesAboveLimit = product.getNoWeeksAboveLimit(100);
		
		assertEquals(expectedSalesAboveLimit, actualSalesAboveLimit);
	}
	
	@Test
	public void testCardinalityWeeksAboveLimitOne() throws WrongSoldItemsException {
		ArrayList<Integer> noProductsSold = new ArrayList<Integer>();
		noProductsSold.add(101);
		product.setSales(noProductsSold);
		
		int expectedSalesAboveLimit = 1;
		int actualSalesAboveLimit = product.getNoWeeksAboveLimit(100);
		
		assertEquals(expectedSalesAboveLimit, actualSalesAboveLimit);
	}
}
