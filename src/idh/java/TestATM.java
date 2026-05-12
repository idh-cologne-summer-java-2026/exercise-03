package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestATM {

	@Test
	public void testValidAmounts() throws ATM.IllegalInputException {
		ATM atm = new ATM();
		
		// Test kleinste mögliche Kombination: 5
		assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 1}, atm.convertToBills(5));
		
		// Test große Kombination: 885 
		assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1}, atm.convertToBills(885));
		
		// Test 
		assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, atm.convertToBills(0));
	}

	@Test
	public void testNegativeAmount() throws ATM.IllegalInputException {
		ATM atm = new ATM();
		// Negative Eingabe soll ein Array voller Nullen zurückgebe
		assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0}, atm.convertToBills(-10));
	}

	@Test
	public void testInvalidAmount() {
		ATM atm = new ATM();
		// 12 ist nicht durch 5 teilbar 
		assertThrows(ATM.IllegalInputException.class, () -> atm.convertToBills(12));
	}
}


