package ro.ase.csie.cts.assignment4.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import ro.ase.csie.cts.assignment4.Product;
import ro.ase.csie.cts.assignment4.categories.ImportantTest;
import ro.ase.csie.cts.assignment4.exceptions.WrongNameException;
import ro.ase.csie.cts.assignment4.exceptions.WrongPriceException;
import ro.ase.csie.cts.assignment4.exceptions.WrongSoldItemsException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TestProduct {

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
	public void testConformanceProductFirstConstructor() {
		String prodName = "Graphics Card";
		float prodPrice = 99;
		Product prod = new Product(prodName, prodPrice);
		assertSame(prodName, prod.getName());
	}
	
	@Test
	public void testConformanceProductSecondConstructor() {
		assertEquals((int) weeklySoldItems.get(0), product.getSoldItems(0));
	}
	
	@Test(expected = WrongPriceException.class)
	public void testErrorConditionPrice() throws WrongPriceException {
		float newPrice = -10;
		product.setPrice(newPrice);
	}
	
	@Test(expected = WrongNameException.class)
	public void testErrorConditionName() throws WrongNameException {
		String newName = " ";
		product.setName(newName);
	}
	
	@Test(expected = WrongSoldItemsException.class)
	public void testErrorConditionSoldItems() throws WrongSoldItemsException {
		ArrayList<Integer> soldItemsPerWeek = new ArrayList<>();
		soldItemsPerWeek.add(22);
		soldItemsPerWeek.add(-99);
		soldItemsPerWeek.add(21);
		product.setSales(soldItemsPerWeek);
	}
	
	@Category(ImportantTest.class)
	@Test(expected = WrongSoldItemsException.class)
	public void testExistenceArrayListConstructor() throws WrongSoldItemsException{
		ArrayList<Integer> soldItemsNull = null;
		product.setSales(soldItemsNull);
	}
	
	@Test
	public void testSetSoldItemsReference() throws WrongSoldItemsException {
		int[] newItems = new int[] {9,9,10};
		
		ArrayList<Integer> refItems = new ArrayList<>();
		for(int item : newItems) {
			refItems.add(item);
		}
		
		product.setSales(refItems);
		
		refItems.set(0, 299);
		
		int[] productSales = new int[product.getNoSales()];
		for(int i = 0; i < product.getNoSales(); i++) {
			productSales[i] = product.getSoldItems(i);
		}
		
		assertArrayEquals(newItems, productSales);
	}
}
