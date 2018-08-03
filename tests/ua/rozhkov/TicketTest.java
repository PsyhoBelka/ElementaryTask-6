package ua.rozhkov;

import org.testng.AssertJUnit.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TicketTest {

	Ticket ticket;

	@org.testng.annotations.BeforeMethod
	public void setUp() throws Exception {
		ticket = new Ticket();
	}

	@DataProvider(name = "simpleCheckTrue")
	public Object[][] simpleCheckDataTrue() {
		return new Object[][]{
				{123123, true},
				{456456, true},
				{789987, true},
				{568829, true}
		};
	}

	@org.testng.annotations.Test(dataProvider = "simpleCheckTrue")
	public void testCheckSimple_True(int number, boolean expected) throws Exception {
//		boolean expected = true;
		boolean actual = ticket.checkSimple(number);
		assertEquals(expected, actual);
	}

	@DataProvider(name = "heavyCheckTrue")
	public Object[][] heavyCheckDataTrue() {
		return new Object[][]{
				{112233, true},
				{465564, true},
				{963369, true},
				{577148, true}
		};
	}

	@org.testng.annotations.Test(dataProvider = "heavyCheckTrue")
	public void testCheckHeavy_True(int number, boolean expected) throws Exception {
		boolean actual = ticket.checkHeavy(number);
		assertEquals(expected, actual);
	}

	@DataProvider(name = "simpleCheckFalse")
	public Object[][] simpleCheckDataFalse() {
		return new Object[][]{
				{111222, false},
				{125965, false},
				{896542, false},
				{121212, false}
		};
	}

	@Test(dataProvider = "simpleCheckFalse")
	public void testCheckSimple_False(int number, boolean expected) throws Exception {
		boolean actual = ticket.checkSimple(number);
		assertEquals(expected, actual);
	}

	@DataProvider(name = "heavyCheckFalse")
	public Object[][] heavyCheckDataFalse() {
		return new Object[][]{
				{162839, false},
				{865742, false},
				{573928, false},
				{169857, false}
		};
	}

	@Test(dataProvider = "heavyCheckFalse")
	public void testCheckHeavy_False(int number, boolean expected) throws Exception {
		boolean actual = ticket.checkHeavy(number);
		assertEquals(expected, actual);
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void testCheckSimple_NumberFormatException() {
		ticket.checkSimple(11315131);
	}

	@Test(expectedExceptions = NumberFormatException.class)
	public void testCheckHeavy_NumberFormatException() {
		ticket.checkHeavy(711315131);
	}

	@org.testng.annotations.Test
	public void testCountSimpleOnRange() throws Exception {
	}

	@org.testng.annotations.Test
	public void testCountHeavyOnRange() throws Exception {
	}

}