package idh.java;

public class LeapYear {
	
	public boolean isLeapYear(int year) throws OutOfRangeException{
		
		boolean isLeap = false;
		
		if(year < 1582){
			throw new OutOfRangeException();
		}
		
		 if(year % 4 == 0){
			 isLeap = true;
		 }
		 if (year % 100 == 0){
			 isLeap = false;
		}
		 if (year % 400 == 0){
			 isLeap = true;
		}
		
		return isLeap;
	
	}
}
