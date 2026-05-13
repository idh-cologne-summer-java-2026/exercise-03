package idh.java;

public class LeapYear {
	
	public boolean isLeapYear(int year) throws OutOfRangeException {
		// Historische Grenze: Gregorianischer Kalender beginnt erst 1582
		if (year < 1582) {
			throw new OutOfRangeException();
		}
		
		// Regel 3: Durch 400 teilbar -> IMMER Schaltjahr
		if (year % 400 == 0) {
			return true;
		}
		
		// Regel 2: Durch 100 teilbar -> KEIN Schaltjahr
		if (year % 100 == 0) {
			return false;
		}
		
		// Regel 1: Durch 4 teilbar -> Schaltjahr
		if (year % 4 == 0) {
			return true;
		}
		
		// Wenn nichts zutrifft -> kein Schaltjah
		return false;
	}
}

