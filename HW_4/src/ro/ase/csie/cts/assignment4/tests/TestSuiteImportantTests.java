package ro.ase.csie.cts.assignment4.tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.csie.cts.assignment4.categories.ImportantTest;

@RunWith(Categories.class)
@IncludeCategory({ImportantTest.class})
@SuiteClasses({ TestProduct.class, TestProduct2.class, TestProduct3.class})
public class TestSuiteImportantTests {

}
