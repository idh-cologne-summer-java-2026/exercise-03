package idh.java;

public class LeapYear {

	
//	public static void main (String args[]) {
//		LeapYear LY = new LeapYear();
//	}
	
	public boolean isLeapYear(int year) throws OutOfRangeException {
			if(year > 0 && year % 4 == 0 && year % 400 == 0 || year/100 != 0 && year >= 1582) { //took some tries
				System.out.println(year + " is a leap year.");
				return true;
			} else {
				System.err.println(year + " is undefined in the gregorian calendar.");
				throw new OutOfRangeException(); //the undefinedTest failed because there was no Exception thrown. Needed to occur in here. No variable for the Exception needed
			}		
	} 
}
