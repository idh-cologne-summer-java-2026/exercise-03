package idh.java;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertArrayEquals;


import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

public class TestATM {
	
	ATM atm = new ATM();
		
		@Test
		public void testAtmCashout() throws IllegalInputException {
			try {
				int[] expected01 = {2,0,0,0,0,0,0};
				assertArrayEquals(expected01, atm.convertToBills(1000));
				int[] expected02 = {3,0,1,1,2,0,0};
				assertArrayEquals(expected02, atm.convertToBills(1690));
				int[] expected03 = {0,0,0,0,0,0,1};
				assertArrayEquals(expected03, atm.convertToBills(5));
				int[] expected04 = {0,0,0,0,0,0,0};
				assertArrayEquals(expected04, atm.convertToBills(-10));
				
			} catch(IllegalInputException e) {
				fail();
			}		
		}
	
		@Test
		public void testAtmIllegalInput() throws IllegalInputException {
	
			assertThrows(IllegalInputException.class, () -> atm.convertToBills(188));
	}			
}
