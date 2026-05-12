package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		
		// vor dem gregorianischen Kalender nicht definiert
		if(year <1582) {
			throw new OutOfRangeException();
		}
		
		if(year %4 ==0) {
			return true;
		}
		
		
		if(year %400==0) {
			return true;
		}
		if(year %100==0) {
			return false;
		}
		
		return false;
	}
}
