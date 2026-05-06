package idh.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TestLeapYear {

	LeapYear leapYearObject = new LeapYear();

	@Test
	public void testActualLeapYears() {
		// 1982 isn't a lap year, changed to 1984
		try {
			// assertTrue(leapYearObject.isLeapYear(1982));
			assertTrue(leapYearObject.isLeapYear(1984));
			assertTrue(leapYearObject.isLeapYear(2000));
			assertTrue(leapYearObject.isLeapYear(2028));
			assertTrue(leapYearObject.isLeapYear(202000));
		} catch (OutOfRangeException e) {
			fail();
		}
	}

	@Test
	public void testNotLeapYears() {
		// no lap years, assertTrue changed to assertFalse
		try {
			assertFalse(leapYearObject.isLeapYear(1983));
			assertFalse(leapYearObject.isLeapYear(2026));
			assertFalse(leapYearObject.isLeapYear(1999));
			assertFalse(leapYearObject.isLeapYear(1998));
			assertFalse(leapYearObject.isLeapYear(1997));
			assertFalse(leapYearObject.isLeapYear(1900));
		} catch (OutOfRangeException e) {
			fail();
		}
	}

	@Test
	public void testUndefined() {
		assertThrows(OutOfRangeException.class, () -> leapYearObject.isLeapYear(1500));
		assertThrows(OutOfRangeException.class, () -> leapYearObject.isLeapYear(-14));
		assertThrows(OutOfRangeException.class, () -> leapYearObject.isLeapYear(-2000));
	}
}