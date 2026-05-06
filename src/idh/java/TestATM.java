package idh.java;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

// Test program
public class TestATM {

	// Program to be tested
	ATM atm = new ATM();
	
	@Test
	// Only one bank note
	public void testOneBanknote() 
	{
		try 
		{
			assertTrue
			(
				atm.convertToBills(500)[0] == 1 &&
				atm.convertToBills(200)[1] == 1 &&				
				atm.convertToBills(100)[2] == 1 &&
				atm.convertToBills(50)[3]  == 1 &&
				atm.convertToBills(20)[4]  == 1 &&
				atm.convertToBills(10)[5]  == 1 &&
				atm.convertToBills(5)[6]   == 1
			);
		}
		catch (IllegalInputException e) 
		{
			fail();
		}
	}
	
	@Test
	// int max = 2,147,483,647 --> 2147483500 in 500 € notes
	public void testBillions() 
	{
		try 
		{
			assertTrue
			(
				atm.convertToBills(2147483500)[0] == 4294967
			);
		}
		catch (IllegalInputException e) 
		{
			fail();
		}
	}
	
	@Test
	// int max = 2,147,483,647 --> 2147483645
	public void testLargestNumber() 
	{
		int[] aiTest = new int[7];
		try 
		{	
			aiTest = atm.convertToBills(2147483645);
			assertTrue
			(
				aiTest[0] == 4294967 &&
				aiTest[1] == 0 &&
				aiTest[2] == 1 &&
				aiTest[3] == 0 &&
				aiTest[4] == 2 &&
				aiTest[5] == 0 &&
				aiTest[6] == 1
			);
		}
		catch (IllegalInputException e) 
		{
			fail();
		}
	}
	
	@Test
	// only a bank note of every kind
	public void testOnlyEveryKind() 
	{
		int[] aiTest = new int[7];
		try 
		{	
			aiTest = atm.convertToBills(885);
			assertTrue
			(
				aiTest[0] == 1 &&
				aiTest[1] == 1 &&
				aiTest[2] == 1 &&
				aiTest[3] == 1 &&
				aiTest[4] == 1 &&
				aiTest[5] == 1 &&
				aiTest[6] == 1
			);
		}
		catch (IllegalInputException e) 
		{
			fail();
		}
	}
	
	@Test
	// Negative number
	public void testNegativeNumber() 
	{
		int[] aiTest = new int[7];
		try 
		{	
			aiTest = atm.convertToBills(-2);
			assertTrue
			(
				aiTest[0] == 0 &&
				aiTest[1] == 0 &&
				aiTest[2] == 0 &&
				aiTest[3] == 0 &&
				aiTest[4] == 0 &&
				aiTest[5] == 0 &&
				aiTest[6] == 0
			);
		}
		catch (IllegalInputException e) 
		{
			fail();
		}
	}

	@Test
	// Zero
	public void testZero() 
	{
		int[] aiTest = new int[7];
		try 
		{	
			aiTest = atm.convertToBills(0);
			assertTrue
			(
				aiTest[0] == 0 &&
				aiTest[1] == 0 &&
				aiTest[2] == 0 &&
				aiTest[3] == 0 &&
				aiTest[4] == 0 &&
				aiTest[5] == 0 &&
				aiTest[6] == 0
			);
		}
		catch (IllegalInputException e) 
		{
			fail();
		}
	}
	
	@Test
	// Test exception was thrown
	public void testThrow() 
	{
		assertThrows(IllegalInputException.class, () -> 
			{
				atm.convertToBills(2);
			}
		);	
	}
	
	@Test
	// int max = 2,147,483,647 --> 2147483647
	public void testIntMax() 
	{
		assertThrows(IllegalInputException.class, () -> 
			{
				atm.convertToBills(2147483647);
			}
		);
	}
}
