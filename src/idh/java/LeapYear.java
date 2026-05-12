package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		
		// Vor dem gregorianischen Kalender nicht definiert 
		if (year < 1582) {
			throw new OutOfRangeException();
		}
		
		// durch 4 teilbar -> Schaltjahr
		if (year % 4 == 0) {
			return true;
		}
		
		
		// durch 400 teilbar -> Schaltjahr 
		if (year % 400 == 0) {
			return true;
		}
		
		
		// durch 100 teilbar -> kein Schaltjahr
		if (year % 100 == 0) {
			return false;
		}
		
		// sonst kein Schaltjjahr 
			return false;
	}
}
