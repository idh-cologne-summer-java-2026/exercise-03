package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {

		if (year < 1582) {
			throw new OutOfRangeException();
		}

		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
}
