package ro.ase.csie.cts.assignment4.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.assignment4.Product;
import ro.ase.csie.cts.assignment4.categories.ImportantTest;
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

	@Category(ImportantTest.class)
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
	
	@Category(ImportantTest.class)
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
	
	@Category(ImportantTest.class)
	@Test
	public void testCardinalityWeeksAboveLimitOne() throws WrongSoldItemsException {
		ArrayList<Integer> noProductsSold = new ArrayList<Integer>();
		noProductsSold.add(101);
		product.setSales(noProductsSold);
		
		int expectedSalesAboveLimit = 1;
		int actualSalesAboveLimit = product.getNoWeeksAboveLimit(100);
		
		assertEquals(expectedSalesAboveLimit, actualSalesAboveLimit);
	}
	
	@Test
	public void testWeeksAboveLimitOrderingAsc() throws WrongSoldItemsException{
		ArrayList<Integer> newSales = new ArrayList<>();
		
		for(int i = 6; i < 10; i++) {
			newSales.add(i);
		}
		
		product.setSales(newSales);
		
		float expectedAverage = 7.5f;
		float actualAverage = product.getAverageSales();
		
		assertEquals(expectedAverage, actualAverage, 0);
	}
	
	@Test
	public void testWeeksAboveLimitOrderingDesc() throws WrongSoldItemsException{
		ArrayList<Integer> newSales = new ArrayList<>();
		
		for(int i = 9; i > 5; i--) {
			newSales.add(i);
		}
		
		product.setSales(newSales);
		
		float expectedAverage = 7.5f;
		float actualAverage = product.getAverageSales();
		
		assertEquals(expectedAverage, actualAverage, 0);
	}
	
	@Test(timeout = 3000)
	public void testPerformanceWeeksAboveLimit() throws WrongSoldItemsException {
		Random random = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1001; i++) {
			list.add(i + 1);
		}
		
		product.setSales(list);
		assertEquals(3, product.getNoWeeksAboveLimit(998));
	}
}
