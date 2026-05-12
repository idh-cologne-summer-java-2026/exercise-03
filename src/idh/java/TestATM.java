package idh.java;

   import static org.junit.jupiter.api.Assertions.*;
   import org.junit.jupiter.api.Test;

  public class TestATM {

	  private final ATM atm = new ATM();
	  
	  @Test

	  public void testConvertToBills_1() throws ATM.IllegalInputException{
	     int [] a = new int [] {0, 0, 0, 0, 0, 0, 1};
	     int [] b = atm.convertToBills(5);
	     assertArrayEquals(a, b);
	    }

	  @Test

	  public void testConvertToBills_2() throws ATM.IllegalInputException{
	     int [] a = new int [] {2, 1, 0, 0, 1, 0, 0};
	     int [] b = atm.convertToBills(1220);
	     assertArrayEquals(a, b);
	    }

	  @Test

	  public void testConvertToBills_3() throws ATM.IllegalInputException{
	     int [] a = new int [] {0, 0, 0, 0, 0, 0, 0};
	     int [] b = atm.convertToBills(-1);
	     assertArrayEquals(a, b);
	    }

}