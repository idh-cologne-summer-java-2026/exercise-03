package idh.java;

public class LeapYear {
	
	public boolean isLeapYear(int year) throws OutOfRangeException {
		
		// 1. Die historische Grenze: Vor 1582 gab es den gregorianischen Kalender nicht
		if (year < 1582) {
			throw new OutOfRangeException(); 
		}
		
		// 2. Die Schaltjahr-Berechnung nach den bekannten Regeln
		if (year % 400 == 0) {
			// Durch 400 teilbar -> IMMER ein Schaltjahr
			return true;
		} else if (year % 100 == 0) {
			// Durch 100 teilbar (aber nicht 400) -> KEIN Schaltjahr
			return false;
		} else if (year % 4 == 0) {
			// Durch 4 teilbar (aber nicht 100) -> Schaltjahr
			return true;
		} else {
			// Alles andere -> KEIN Schaltjahr
			return false;
		}
	}
}