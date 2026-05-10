package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		if (year <= 1500) {
			throw new OutOfRangeException();
		}
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		} return false;
	}
}
