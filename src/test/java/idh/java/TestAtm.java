package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class TestAtm {

    ATM tatm = new ATM();

    @Test
    void negativeValue() throws ATM.IllegalInputException {
            assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, tatm.convertToBills(-10));
    }

    @Test
    void notDividableby5() throws ATM.IllegalInputException {
            assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, tatm.convertToBills(6));
    }
}

