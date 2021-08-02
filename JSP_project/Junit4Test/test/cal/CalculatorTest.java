package cal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		Calculator cal = new Calculator();
		System.out.println(cal.add(10, 2));
		//fail("Not yet implemented");
	}

	@Test
	public void testSubstract() {
		System.out.println("substract()");
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		System.out.println("multiply()");
		//fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		System.out.println("divde()");
		//fail("Not yet implemented");
	}

}
