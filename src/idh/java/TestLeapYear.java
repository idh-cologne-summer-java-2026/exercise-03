package idh.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TestLeapYear {

	LeapYear leapYearObject = new LeapYear();

	@Test
	public void testActualLeapYears() {
		try {
			assertTrue(leapYearObject.isLeapYear(1980)); // changed from 1982 to 1980, as 1982 isn't a leap year
			assertTrue(leapYearObject.isLeapYear(2000));
			assertTrue(leapYearObject.isLeapYear(2028));
			assertTrue(leapYearObject.isLeapYear(202000));
		} catch (OutOfRangeException e) {
			fail();
		}
	}

	@Test
	/* all tests in this method changed from assertTrue to assertFalse as 
	 * none of the years tested is a leap year*/
	public void testNotLeapYears() {
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
		/* first test value in this method changed from 1500 to 1581, 
		 * because otherwise wrong values in the conditional 
		 * ranging from 1501 to 1581 would not be detected */
		assertThrows(OutOfRangeException.class, () -> leapYearObject.isLeapYear(1581)); 	  
		assertThrows(OutOfRangeException.class, () -> leapYearObject.isLeapYear(-14));
		assertThrows(OutOfRangeException.class, () -> leapYearObject.isLeapYear(-2000));

	}

}
