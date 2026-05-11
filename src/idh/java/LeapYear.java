package idh.java;

public class LeapYear {

	public boolean isLeapYear(int year) throws OutOfRangeException {
		//Calender reform in 1582
		if (year < 1582) {
			throw new OutOfRangeException();
		}
		
		if (year % 400 == 0) {
			return true;
		}
		// Divisible by 100 (but not 400) -> not a leap year
		if (year % 100 == 0) {
			return false;
		}
		// Divisible by 4 (but not 100) -> leap year
		if (year % 4 == 0) {
			return true;
		}
		// All other years -> not a leap year
		return false;
	}
}
