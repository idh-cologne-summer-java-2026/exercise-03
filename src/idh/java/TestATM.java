package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

class TestATM {

	ATM atmObject = new ATM();
	
	
	@Test
	public void testBiggestBills () throws IllegalInputException {
		assertArrayEquals(new int[] {0, 0, 1, 1, 0, 0, 1}, atmObject.convertToBills(155));
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 1}, atmObject.convertToBills(5));
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 1, 0}, atmObject.convertToBills(10));
		assertArrayEquals(new int[] {0, 0, 0, 0, 1, 0, 1}, atmObject.convertToBills(25));
		assertArrayEquals(new int[] {0, 0, 0, 0, 2, 0, 1}, atmObject.convertToBills(45));
		assertArrayEquals(new int[] {0, 0, 0, 1, 0, 0, 0}, atmObject.convertToBills(50));
		assertArrayEquals(new int[] {0, 0, 0, 1, 2, 0, 1}, atmObject.convertToBills(95));
		assertArrayEquals(new int[] {0, 0, 1, 0, 0, 0, 0}, atmObject.convertToBills(100));
		assertArrayEquals(new int[] {0, 1, 1, 1, 1, 1, 0}, atmObject.convertToBills(380));
		assertArrayEquals(new int[] {1, 2, 0, 0, 2, 0, 0}, atmObject.convertToBills(940));
		assertArrayEquals(new int[] {2, 0, 0, 0, 0, 0, 0}, atmObject.convertToBills(1000));
		assertArrayEquals(new int[] {40, 2, 0, 1, 1, 1, 1}, atmObject.convertToBills(20485));
	}

	@Test
	public void testNegativeNumbers() throws IllegalInputException {
		int[] expected = new int[] {0, 0, 0, 0, 0, 0, 0};
		assertArrayEquals(expected, atmObject.convertToBills(-0));
		assertArrayEquals(expected, atmObject.convertToBills(-1));
		assertArrayEquals(expected, atmObject.convertToBills(-500000));	
	}
	@Test
	public void testNoDivisionByFive() {	
		assertThrows(IllegalInputException.class, () -> atmObject.convertToBills(1));
		assertThrows(IllegalInputException.class, () -> atmObject.convertToBills(7));
		assertThrows(IllegalInputException.class, () -> atmObject.convertToBills(524));
		assertThrows(IllegalInputException.class, () -> atmObject.convertToBills(1178));
	}
}


