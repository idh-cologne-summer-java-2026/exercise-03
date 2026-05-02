package idh.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {

	ATM atm = new ATM();
	
	@Test
	public void testConvertToBills() {
		try {
		assertTrue(
				atm.convertToBills(100)[0] == 0 &&
				atm.convertToBills(100)[1] == 0 &&				
				atm.convertToBills(100)[2] == 1 &&
				atm.convertToBills(100)[3] == 0 &&
				atm.convertToBills(100)[4] == 0 &&
				atm.convertToBills(100)[5] == 0 &&
				atm.convertToBills(100)[6] == 0);
		assertTrue(
				atm.convertToBills(95)[0] == 0 &&
				atm.convertToBills(95)[1] == 0 &&				
				atm.convertToBills(95)[2] == 0 &&	
				atm.convertToBills(95)[3] == 1 &&
				atm.convertToBills(95)[4] == 2 &&
				atm.convertToBills(95)[5] == 0 &&
				atm.convertToBills(95)[6] == 1);
		assertTrue(
				atm.convertToBills(85)[0] == 0 &&
				atm.convertToBills(85)[1] == 0 &&				
				atm.convertToBills(85)[2] == 0 &&
				atm.convertToBills(85)[3] == 1 &&
				atm.convertToBills(85)[4] == 1 &&
				atm.convertToBills(85)[5] == 1 &&
				atm.convertToBills(85)[6] == 1);
		}catch (IllegalInputException e) {
			fail();
			}
	}
	
	@Test 
	public void testNegConvertToBills() {
		try {
		assertEquals(0, 
				atm.convertToBills(-5)[0] +
				atm.convertToBills(-5)[1] +				
				atm.convertToBills(-5)[2] +
				atm.convertToBills(-5)[3] +
				atm.convertToBills(-5)[4] +
				atm.convertToBills(-5)[5] +
				atm.convertToBills(-5)[6]);
		assertEquals(0,
				atm.convertToBills(-100)[0] +
				atm.convertToBills(-100)[1] +				
				atm.convertToBills(-100)[2] +
				atm.convertToBills(-100)[3] +
				atm.convertToBills(-100)[4] +
				atm.convertToBills(-100)[5] +
				atm.convertToBills(-100)[6]);
		assertEquals(0,
				atm.convertToBills(-27)[0] +
				atm.convertToBills(-27)[1] +				
				atm.convertToBills(-27)[2] +
				atm.convertToBills(-27)[3] +
				atm.convertToBills(-27)[4] +
				atm.convertToBills(-27)[5] +
				atm.convertToBills(-27)[6]);
		}catch (IllegalInputException e) {
			fail();
			}
	}
	
	
	@Test
	public void testIllegalInput() {
		assertThrows(IllegalInputException.class, () -> atm.convertToBills(4));
		assertThrows(IllegalInputException.class, () -> atm.convertToBills(6));		
		assertThrows(IllegalInputException.class, () -> atm.convertToBills(99));
	}
	
}
