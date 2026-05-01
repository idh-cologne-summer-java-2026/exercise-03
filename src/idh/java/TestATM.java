package idh.java;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TestATM {
	
	
	// Wenn die Klasse TestATM im gleichen Package liegt, darf sie auf die Methode convertToBills zugreifen.
	// Die Klasse könnte auch in einem anderen Package liegen, allerdings dürfte die Methode convertToBills dann nicht protected sein.

	
	
	// 1. Test: Nicht durch 5 Teilbar wirft IllegalInputException
    @Test
    public void testNullBetrag() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(0);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, result);
        
    }
    
    @Test
    public void testNichtDurch5Teilbar() {
        ATM atm = new ATM();

        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(1);
        });
    }

    @Test
    public void testNichtDurch5Teilbar2() {
        ATM atm = new ATM();

        assertThrows(ATM.IllegalInputException.class, () -> {
            atm.convertToBills(999);
        });
    }

    
 
    // 2. Test: Wird eine Stückelung erzeugt die möglichst wenige Scheine braucht?
    @Test
    public void testGroßeScheine() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(1250);

        assertArrayEquals(new int[] {2, 1, 0, 1, 0, 0, 0}, result);
    }
    
    @Test
    public void testGrößteDurch5TeilbareZahl() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(2147483645);

        assertArrayEquals(new int[] {4294967, 0, 1, 0, 2, 0, 1}, result);
    }
    
    @Test
    public void test5E() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(5);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 1}, result);
    }

    @Test
    public void test10E() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(10);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 1, 0}, result);
    }

    @Test
    public void test20E() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(20);

        assertArrayEquals(new int[] {0, 0, 0, 0, 1, 0, 0}, result);
    }

    @Test
    public void test50E() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(50);

        assertArrayEquals(new int[] {0, 0, 0, 1, 0, 0, 0}, result);
    }

    @Test
    public void test100E() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(100);

        assertArrayEquals(new int[] {0, 0, 1, 0, 0, 0, 0}, result);
    }

    @Test
    public void test500E() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(500);

        assertArrayEquals(new int[] {1, 0, 0, 0, 0, 0, 0}, result);
    }

    @Test
    public void testAusgabeAlleScheine() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(885);

        assertArrayEquals(new int[] {1, 1, 1, 1, 1, 1, 1}, result);
    }


    
    //  3. Test: Negative Zahlen
    @Test
    public void testNegativeZahlen() throws ATM.IllegalInputException {
        ATM atm = new ATM();

        int[] result = atm.convertToBills(-5);
        int[] result2 = atm.convertToBills((int)-0.9);
        int[] result3 = atm.convertToBills((int)-245235);

        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, result);
        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, result2);
        assertArrayEquals(new int[] {0, 0, 0, 0, 0, 0, 0}, result3);
    }

    
    
    }