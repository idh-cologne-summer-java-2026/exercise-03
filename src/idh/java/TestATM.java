package idh.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestATM {

    @Test
    void testIllegalInput() {

        ATM atm = new ATM();

        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(12);
        });

    }
}