package idh.java;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import idh.java.ATM.IllegalInputException;

public class TestATM1 {
    @Test
    void testDivisibleCasesProduceMinimalBills() throws ATM.IllegalInputException{
        //0 -> keine Scheine
        assertArrayEquals(new int []{0, 0, 0, 0, 0, 0, 0}, ATM.convertToBills(0));

        //125 -> 100er, 20er und 5er Schein
        assertArrayEquals(new int[]{0,0,1,0,1,0,1}, ATM.convertToBills(125));

        //2-3 weitere Tests einbauen
    }

    @Test
    void testNegativeReturnsZero() throws IllegalInputException{
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, ATM.convertToBills(-300));
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, ATM.convertToBills(-3));
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, ATM.convertToBills(-54));
        assertArrayEquals(new int[]{0,0,0,0,0,0,0}, ATM.convertToBills(-125));
    }

    @Test
    void testNonMultipleOfFiveThrows(){
        assertThrows(ATM.IllegalInputException.class, () -> ATM.convertToBills(1));
        assertThrows(ATM.IllegalInputException.class, () -> ATM.convertToBills(7));
        assertThrows(ATM.IllegalInputException.class, () -> ATM.convertToBills(99));
        assertThrows(ATM.IllegalInputException.class, () -> ATM.convertToBills(48));
    }

    @Test
    void testVeryLargeDivisibleAmountSumMatches() throws ATM.IllegalInputException{
        int maxDivisible = Integer.MAX_VALUE - (Integer.MAX_VALUE % 5); //den maxValue durch 5 teilbar machen
        int[] counts = ATM.convertToBills(maxDivisible);
        long sum =  (long)counts[0]*500 + (long)counts[1]*200 + (long)counts[2]*100 + (long)counts[3]*50 + (long)counts[4]*20 + (long)counts[5]*10 + (long)counts[6]*5;
        assertEquals((long) maxDivisible, sum);
    }
}
