package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestATM {

    ATM atm = new ATM();

    @Test
    public void testZeroAmount() throws ATM.IllegalInputException {
        assertArrayEquals(
            new int[] {0, 0, 0, 0, 0, 0, 0},
            atm.convertToBills(0)
        );
    }

    @Test
    public void testSmallestPossibleAmount() throws ATM.IllegalInputException {
        assertArrayEquals(
            new int[] {0, 0, 0, 0, 0, 0, 1},
            atm.convertToBills(5)
        );
    }

    @Test
    public void testSimpleAmounts() throws ATM.IllegalInputException {
        assertArrayEquals(
            new int[] {0, 0, 0, 0, 0, 1, 0},
            atm.convertToBills(10)
        );

        assertArrayEquals(
            new int[] {0, 0, 0, 0, 1, 0, 1},
            atm.convertToBills(25)
        );

        assertArrayEquals(
            new int[] {0, 0, 1, 1, 1, 0, 1},
            atm.convertToBills(175)
        );
    }

    @Test
    public void testLargeBillsArePreferred() throws ATM.IllegalInputException {
        assertArrayEquals(
            new int[] {1, 0, 0, 0, 0, 0, 0},
            atm.convertToBills(500)
        );

        assertArrayEquals(
            new int[] {1, 1, 1, 1, 1, 1, 1},
            atm.convertToBills(885)
        );

        assertArrayEquals(
            new int[] {2, 0, 0, 0, 0, 0, 0},
            atm.convertToBills(1000)
        );
    }

    @Test
    public void testNegativeAmount() throws ATM.IllegalInputException {
        assertArrayEquals(
            new int[] {0, 0, 0, 0, 0, 0, 0},
            atm.convertToBills(-5)
        );

        assertArrayEquals(
            new int[] {0, 0, 0, 0, 0, 0, 0},
            atm.convertToBills(Integer.MIN_VALUE)
        );
    }

    @Test
    public void testLargestDivisibleInteger() throws ATM.IllegalInputException {
        assertArrayEquals(
            new int[] {4294967, 0, 1, 0, 2, 0, 1},
            atm.convertToBills(2147483645)
        );
    }

    @Test
    public void testIllegalAmounts() {
        assertThrows(
            ATM.IllegalInputException.class,
            () -> atm.convertToBills(1)
        );

        assertThrows(
            ATM.IllegalInputException.class,
            () -> atm.convertToBills(99)
        );

        assertThrows(
            ATM.IllegalInputException.class,
            () -> atm.convertToBills(Integer.MAX_VALUE)
        );
    }
}