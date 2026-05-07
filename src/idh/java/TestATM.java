package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;

public class TestATM {
	
	ATM atmObject = new ATM();

	@Test
	public void TestUndefined() {
		assertThrows(ATM.IllegalInputException.class, () -> atmObject.convertToBills(53));
		assertThrows(ATM.IllegalInputException.class, () -> atmObject.convertToBills(789));
		assertThrows(ATM.IllegalInputException.class, () -> atmObject.convertToBills(901));
		assertThrows(ATM.IllegalInputException.class, () -> atmObject.convertToBills(24));
	}
	
	@Test
	public void Testnegative() throws ATM.IllegalInputException{
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, atmObject.convertToBills(-10));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, atmObject.convertToBills(-8));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, atmObject.convertToBills(-19));
		assertArrayEquals(new int[] {0,0,0,0,0,0,0}, atmObject.convertToBills(-799));
	}
	
	@Test
	public void TestConvertible() throws ATM.IllegalInputException{
		assertArrayEquals(new int[] {1,0,0,0,0,0,0}, atmObject.convertToBills(500));
		assertArrayEquals(new int[] {0,0,0,0,0,1,0}, atmObject.convertToBills(10));
		assertArrayEquals(new int[] {4,0,0,0,0,0,0}, atmObject.convertToBills(2000));
		assertArrayEquals(new int[] {0,0,1,0,0,0,0}, atmObject.convertToBills(100));
		assertArrayEquals(new int[] {0,0,0,1,1,0,0}, atmObject.convertToBills(70));
		assertArrayEquals(new int[] {0,1,0,1,0,0,1}, atmObject.convertToBills(255));
		assertArrayEquals(new int[] {0,0,0,0,0,0,1}, atmObject.convertToBills(5));
	}
}
