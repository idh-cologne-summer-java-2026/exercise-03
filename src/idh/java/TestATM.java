package idh.java;
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException; 

// Die Klasse muss im selben Package leigen, damit wir auf die protected methode ConvertToBills zugreifen könnne

public class TestATM {
	ATM atm1 = new ATM(); 

	
	
	@Test
	void ConvertTester () throws IllegalInputException {
		
		//Test mit 100 Euro 
		int[] Scheine = atm1.convertToBills(100); 
		assertEquals(0, Scheine[0]); 
		assertEquals(0, Scheine[1]); 
		assertEquals(1, Scheine[2]); 
		assertEquals(0, Scheine[3]); 
		assertEquals(0, Scheine[4]);
		assertEquals(0, Scheine[5]);
		assertEquals(0, Scheine[6]);
		
		//Test mit 5000 Euro 
				Scheine = atm1.convertToBills(5000); 
				assertEquals(10, Scheine[0]); 
				assertEquals(0, Scheine[1]); 
				assertEquals(0, Scheine[2]); 
				assertEquals(0, Scheine[3]); 
				assertEquals(0, Scheine[4]);
				assertEquals(0, Scheine[5]);
				assertEquals(0, Scheine[6]);
				
				//Test mit 5 Euro 
				Scheine = atm1.convertToBills(5); 
				assertEquals(0, Scheine[0]); 
				assertEquals(0, Scheine[1]); 
				assertEquals(0, Scheine[2]); 
				assertEquals(0, Scheine[3]); 
				assertEquals(0, Scheine[4]);
				assertEquals(0, Scheine[5]);
				assertEquals(1, Scheine[6]);
		
				//Test mit einer negativen Zahl 
				Scheine = atm1.convertToBills(-5); 
				assertEquals(0, Scheine[0]); 
				assertEquals(0, Scheine[1]); 
				assertEquals(0, Scheine[2]); 
				assertEquals(0, Scheine[3]); 
				assertEquals(0, Scheine[4]);
				assertEquals(0, Scheine[5]);
				assertEquals(0, Scheine[6]);
				
				//Test mit einer ungeraden Zahl 
				assertThrows(IllegalInputException.class, () -> atm1.convertToBills(23));
	}

}
