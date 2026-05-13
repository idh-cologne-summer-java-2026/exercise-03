package idh.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class TestLeapYear {

	LeapYear leapYearObject = new LeapYear();

	@Test
	public void testActualLeapYears() {
		try {
			//1982 is not a leap year?? this drove me up the wall and i'm commenting it out
			//assertTrue(leapYearObject.isLeapYear(1982)); the line in question
			assertTrue(leapYearObject.isLeapYear(2000));
			assertTrue(leapYearObject.isLeapYear(2028));
			assertTrue(leapYearObject.isLeapYear(202000));
		} catch (OutOfRangeException e) { 
			fail();
		}
	}

	@Test
	//here we are testing not-leap years but we use asserttrue to check the non-leap years which would just fail each time.
	//(if our leapyear implementation works)
	//I might be missing something? I just negated the original statements so it makes sense
	public void testNotLeapYears() {
		try {
			assertTrue(!leapYearObject.isLeapYear(1983));
			assertTrue(!leapYearObject.isLeapYear(2026));
			assertTrue(!leapYearObject.isLeapYear(1999));
			assertTrue(!leapYearObject.isLeapYear(1998));
			assertTrue(!leapYearObject.isLeapYear(1997));
			assertTrue(!leapYearObject.isLeapYear(1900));
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
