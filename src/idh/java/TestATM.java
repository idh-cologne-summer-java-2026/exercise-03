package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.Test;

public class TestATM {
	
	private final ATM atm = new ATM();

	@Test
	public void testConvertToBills_MinimumAmount() throws ATM.IllegalInputException {
		int[] expected = new int[] {0, 0, 0, 0, 0, 0, 0, 1};
		int[] actual = atm.convertToBills(5);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testConvertToBills_LargeAmount() throws ATM.IllegalInputException {
		int[] expected = new int[] {1, 0, 0, 0, 0, 0, 0, 0};
		int[] actual = atm.convertToBills(500);
		assertArrayEquals(expected, actual);
	} //test test 
} 