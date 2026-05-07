package idh.java;

public class LeapYear {
	public boolean isLeapYear(int year) throws OutOfRangeException {
	    boolean isLeapYear;
	    
	    if(year <= 1582) {
	    	throw new OutOfRangeException();
	    }
	    
	    if (year % 4 == 0 && year % 100 != 0)
	    {isLeapYear = true;}
	    
	    else if (year % 100 == 0 && year % 400 == 0)
	    {isLeapYear = true;}
	    
	    else
	    {isLeapYear = false;}
	 
	    return isLeapYear;
	    
	}
	
}

