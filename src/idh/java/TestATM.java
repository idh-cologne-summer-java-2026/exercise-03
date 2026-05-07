package idh.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestATM {

	/*
	 * @Before
	 * public void setUp()	{
	 * atm = new ATM();		//Creates ATM for all tests
	 * }
	 */
	
	@Test
	void testAmountZero() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(0);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, result);
    }
	
	@Test
	void testNegativeAmount() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(-50);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, result);
    }
	
	@Test
	void testSmallestAmount() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(5);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 1}, result);
    }
	
	@Test
	void testLargeAmount() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(885);

        assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1}, result);
    }
	
	@Test
	void testDivisibleByFive() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        assertThrows(ATM.IllegalInputException.class, () -> {	//method runs and exception is expected
            atm.convertToBills(13);
        });
	}

}
