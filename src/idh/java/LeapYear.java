package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		
		if (year < 1582) throw new OutOfRangeException();

	    return true;
	    
//	    Lösung für richtigen Test		
//	    if (year % 4 != 0) {
//	    	return false;
//	    	
//	    } else if (year % 400 == 0) {
//	    	return true;
//	    			
//	    } else if (year % 100 == 0) {
//	    	return false;
//	    	
//	    } else return true;

	}
	
}
