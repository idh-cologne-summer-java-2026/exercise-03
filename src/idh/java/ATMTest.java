package idh.java;
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

public class ATMTest {
  
	@Test
	public void testConvertToBillsNormal() throws ATM.IllegalInputException {
		ATM atm = new ATM(); 
		int[] result = atm.convertToBills(135); 
		int [] expected = {0,0,1,0,1,1,1}; 
		assertArrayEquals(result,expected); 
	}
	@Test 
	public void testConvertToBillsMinimum() throws ATM.IllegalInputException {
		ATM atm = new ATM(); 
		int[] result = atm.convertToBills(5); 
		int[] expected = {0,0,0,0,0,0,1}; 
		assertArrayEquals(result, expected); 
	}
	@Test  
	public void testConvertToBillsLarge() throws ATM.IllegalInputException {
		ATM atm = new ATM(); 
		int[] result = atm.convertToBills(2215); 
		int[] expected = {4,1,0,0,0,1,1}; 
		assertArrayEquals(result,expected); 
	}
	@Test
	public void testNegative() throws ATM.IllegalInputException {
		ATM atm = new ATM(); 
		int[]result = atm.convertToBills(-55); 
		int[] expected = {0,0,0,0,0,0,0}; 
		assertArrayEquals(result,expected); 
	}
	@Test
	public void testInvalidInput() throws ATM.IllegalInputException {
		ATM atm = new ATM(); 
		assertThrows(ATM.IllegalInputException.class, () ->{
			atm.convertToBills(21); 
		}); 
	}
}