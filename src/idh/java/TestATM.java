package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import idh.java.ATM.IllegalInputException;

import org.junit.jupiter.api.Test;

class TestATM {

ATM atm = new ATM();
	
	@Test
	public void Tests() {
		
		try {
			//check correct bill amt with number divisible by 5 within atm balance range
			int[] fiveBucks = {0,0,0,0,0,0,1};
			assertArrayEquals(atm.convertToBills(5),fiveBucks);
			int[] fiftyFiveBucks = {0,0,0,1,0,0,1};
			assertArrayEquals(atm.convertToBills(55),fiftyFiveBucks);
			int[] emptyResult = new int[] {0, 0, 0, 0, 0, 0, 0};
			//check for a 0 array upon negative input
			assertArrayEquals(emptyResult, atm.convertToBills(-1));
			//Check if it throws the correct exception
			assertThrows(IllegalInputException.class, () -> atm.convertToBills(3));
		} catch (IllegalInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
