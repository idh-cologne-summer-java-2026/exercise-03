package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {

	ATM atm;

	@BeforeEach
	public void setup() {
		atm = new ATM();
	}

	@Test
	public void testConvertToBillsPositiveCases() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(0));
		assertArrayEquals(new int[] { 1, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(500));
		assertArrayEquals(new int[] { 0, 1, 0, 0, 0, 0, 1 }, atm.convertToBills(205));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 2, 0, 1 }, atm.convertToBills(45));
	}

	@Test
	public void testConvertToBillsNegativeInput() throws IllegalInputException {
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-5));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-15));
		assertArrayEquals(new int[] { 0, 0, 0, 0, 0, 0, 0 }, atm.convertToBills(-17));
	}
	
	@Test
	public void testNotDivisableByFive() {
		assertThrows(ATM.IllegalInputException.class, () -> {
			atm.convertToBills(17);
		});
		assertThrows(ATM.IllegalInputException.class, () -> {
			atm.convertToBills(281);
		});
	}
	
}
