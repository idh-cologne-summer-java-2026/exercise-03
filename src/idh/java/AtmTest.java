package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AtmTest {

	private ATM atm = new ATM(); 
	
	@Test 
	void testStandard() throws ATM.IllegalInputException{
		int[] expected = {0, 0, 1, 0, 1, 1, 1};
		assertArrayEquals(expected, atm.convertToBills(135)); 
	}
	void testSmallestAmount() throws ATM.IllegalInputException{
		int[] expected = {0, 0, 0, 0, 0, 0, 1};
        assertArrayEquals(expected, atm.convertToBills(5));
	}
	void testLargestAmount() throws ATM.IllegalInputException{
		int[] expected = {2, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, atm.convertToBills(1000));
	}
	void testNegativeAmount() throws ATM.IllegalInputException {
        int[] expected = {0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, atm.convertToBills(-50));
    }
	void testIllegalInputException() {
        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(13);
        } );
    }
}
