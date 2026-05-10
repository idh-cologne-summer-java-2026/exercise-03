package idh.java;

import org.junit.jupiter.api.Test;

import idh.java.ATM.IllegalInputException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;



public class TestATM {
 ATM testATM = new ATM();
 int amount1 = 575;
 int amount2 = -123;
 int amount3 = 792832;
 int hugeAmount = 699927865; //699927500 / 500 = 1399855 R365 -> 365/200 = 1R165 -> 165/100 = 1 R65 -> 65/50 = 1R15 -> 15/20= 0R15 -> 15/10 = 1 R5 -> 5/5 =1
 int nonDividableAmount = 129;
 
 int[] case1 = {1,0,0,1,1,0,1}; //575 -> 1 * 500 + 0 * 200 + 0 * 100 + 1*50 + +2*10 + 0*10 + 1*5 + 0*1
 int[] case3 = {1400, 464,0,0,1,1,0,2};
 int[] case4 = {1399855, 1, 1, 1, 0, 1, 1};
 
 
 /*I need to create multiple testMethods to see individual test results. Right now, I can only see if all tests pass and consequently,
 the method stops if one test does not pass */
 
 /** Testing the convertToBills method.
  * The 2nd {@code assertThrows method} (line 42) does not pass, since the expected exception is caught beforehand. Thus the {@code assertThrows Method does not receive an exception and fails.} 
  * **/
 @Test
 public void testConvertToBills() {
//	 int [] targetArray = {1,0,0,1,1,1,0};
	 try {
		 assertArrayEquals(case1, testATM.convertToBills(amount1)) ;
		 assertThrows(IllegalArgumentException.class, () ->  testATM.convertToBills(amount2)); // does not pass since the exception is already being caught
		 assertThrows(IllegalInputException.class, ()-> testATM.convertToBills(amount3));  
		 
		 /*
		  * This test does not fail, but is again a false positive. Thus it still produces an error message on the console. 
		  */ 
//		 assertArrayEquals(case3, testATM.convertToBills(amount3));
		
		 
	 }catch(IllegalInputException e) {
		 System.out.println("IllegalInputException caught.");
		 e.printStackTrace();
	 }
 }
 
 
 /** Replaced by an {@code assertThrows} statement.
  * Copied solution found online as I couldn't solve this one... <br>Originally, {@code assertArrayEquals} was used.<br>
  * It was asserted that the equals method fails, which it should since the input value is negative.<br>
  * This produced a "false positive"(?) as no exception was caught. {@code AssertThrows}is more appropriate here, it seems.
  * This solution is using the <b>lamda</b> operator, although I still don't fully understand what it does.<p>
  * UPDATE: The {@code assertThrows} method differs from {@code assertEquals} methods in the way that it does not run the passed method immediately,
  * as that would crash the program (since it throws the exception right away). Instead, the <b>lamda</b> operator -> ( ) receives the method to be used without 
  * executing it right away, allowing it to check against the {@code IllegalInputException}. <br> (Still not 100% confident whether I understood this completely -_-)
  * <p>It should be noted that {@code assertThrows} does not compare an expected result with the actual one, but just checks if an exception is being thrown
  * and whether it is of the correct type, thus there was no need for an array containing the expected result. 
  **/
 @Test
 public void negativeNum() {
	 int[] case2 = {0,0,0,0,0,0,0}; //-123 -> returns an empty array
	
	 //passes since an empty array is returned as expected
	 try {
		assertArrayEquals(case2, testATM.convertToBills(amount2));
	} catch (IllegalInputException e) {
		System.out.println("An IllegalInputException was caught.");
		e.printStackTrace();
	} 
	 
 }
 
 @Test
 public void nonDivisible() {
	 assertThrows(IllegalInputException.class, ()-> testATM.convertToBills(nonDividableAmount));
 }
 
 @Test
 public void hugeNum() {
	 try {
		assertArrayEquals(case4, testATM.convertToBills(hugeAmount));
	 } catch (IllegalInputException e) {
		
		e.printStackTrace();
	 }
 }
 
}
