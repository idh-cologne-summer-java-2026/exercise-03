package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestATM {

	ATM atm = new ATM();

	@Test
	public void testValidAmounts() throws ATM.IllegalInputException {
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, atm.convertToBills(0));
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 1}, atm.convertToBills(5));
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 1, 0}, atm.convertToBills(10));
		assertArrayEquals(new int[] {0, 0, 0, 0, 1, 0, 0}, atm.convertToBills(20));
		assertArrayEquals(new int[] {0, 0, 0, 1, 0, 0, 0}, atm.convertToBills(50));
		assertArrayEquals(new int[] {0, 0, 1, 0, 0, 0, 0}, atm.convertToBills(100));
		assertArrayEquals(new int[] {0, 1, 0, 0, 0, 0, 0}, atm.convertToBills(200));
		assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0}, atm.convertToBills(500));
		assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1}, atm.convertToBills(885));
	}

	@Test
	public void testNegativeAmount() throws ATM.IllegalInputException {
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, atm.convertToBills(-5));
		assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, atm.convertToBills(-100));
	}

	@Test
	public void testIllegalInput() {
		assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(1));
		assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(3));
		assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(99));
	}
}
