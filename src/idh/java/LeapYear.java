package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
		//Vor dem gregorianischen Kalender nicht defininiert
		if (year < 1582){
			throw new OutOfRangeException();
		}

		//durch 4 teilbar -> Schaltjahr; durch 100 teilbar -> kein Schaltjahr, aber wiederum durch 400 -> Schaltjahr
		if (year % 4 == 0 && (year % 100 == 0 && year % 400 == 0)){
			return true;
		}
		else{
			return false;
		}
	}
}
