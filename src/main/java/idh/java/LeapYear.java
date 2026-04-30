package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		if (year % 400 == 0 && year >= 1582) {
			return true;
		} else if (year % 4 == 0 && year % 100 != 0 && year >= 1582) {
			return true;
		} else {
			return false;
		}
	}
}
