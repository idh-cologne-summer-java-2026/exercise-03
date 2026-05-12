package idh.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestATM {

    ATM atm = new ATM();

    @Test
    void test350() throws Exception {

        int[] expected = {0,1,1,1,1,1,1};
        int[] result = atm.convertToBills(350);

        assertEquals(expected, result);
    }
    
    @Test
    void test5() throws Exception {
    
    	int[] expected = {0,0,0,0,0,0,1};
    	int[] result = atm.convertToBills(5);
    	
    	assertEquals(expected, result);
    }
    
    @Test
    void testConvert555() throws Exception {
    	
    	int[] expected = {1,0,0,1,0,0,1};
    	int[] result = atm.convertToBills(555);
    	
    	assertEquals(expected, result);
    }
    
    @Test
    void testNegativeNumber() throws Exception {
    	
    	int[] expected = {0,0,0,0,0,0,0};
    	int[] result = atm.convertToBills(-10);
    	
    	assertEquals(expected, result);
    }
     
    @Test
    void testIllegalInput() {
    	// ?????
    
    	}
    }
    
    
    
    
   
    
    
    

