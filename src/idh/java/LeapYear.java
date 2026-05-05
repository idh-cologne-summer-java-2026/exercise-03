package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		// Gregorianischer Kalender ab 1582
		if (year < 1582) {
			throw new OutOfRangeException();
		}
		if (year % 4 != 0) {
			return false;
		}
		if (year % 100 != 0) {
			return true;
		}
		return (year % 400 == 0);
	}
}
