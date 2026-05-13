package idh.java;

public class LeapYear {
	
	public boolean isLeapYear(int year) throws OutOfRangeException {
		
		boolean isLeapYear = false;
		//1582, cause history
		if(year < 1582) {
			throw new OutOfRangeException();
		}
		
		if (year % 400 == 0) {
			isLeapYear = true;
		}
		else if (year % 100 == 0) {
			isLeapYear = false;
		}
		else if (year % 4 == 0) {
			isLeapYear = true;
		}
		else {
			isLeapYear = false;
		}
		
		return isLeapYear;
	}
}
