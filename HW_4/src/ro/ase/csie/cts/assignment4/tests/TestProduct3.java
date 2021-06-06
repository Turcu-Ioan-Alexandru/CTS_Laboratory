package ro.ase.csie.cts.assignment4.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import junit.framework.Assert;
import ro.ase.csie.cts.assignment4.Product;
import ro.ase.csie.cts.assignment4.categories.ImportantTest;
import ro.ase.csie.cts.assignment4.exceptions.WrongSoldItemsException;

public class TestProduct3 {

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
		weeklySoldItems.add(100);
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
	public void testPercentageBadWeeksRight() {
		assertEquals(25, product.getPercentOfBadWeeks(30));
	}
	
	@Test
	public void testMaxSalesIndexRight() throws WrongSoldItemsException{
		ArrayList<Integer> noProductsSold = new ArrayList<Integer>();
		noProductsSold.add(3);
		
		ArrayList<Integer> sales = product.getWeeksIndexWithMaxSales();
		assertThat(sales, CoreMatchers.is(noProductsSold));
		
	}
}
