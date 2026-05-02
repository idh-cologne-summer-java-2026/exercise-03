package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		if (year < 1752) {
			 throw new OutOfRangeException("Hier ist ein Problem"); 
			
		}
		
	if (year % 4 == 0) {
		if (year % 100  == 0) {
			if (year % 400 == 0) {
				return true; 
			}
			return false; 
		}
		return true; 
	}
	else {
		return false; 
	}
	
	
	
	}
}
