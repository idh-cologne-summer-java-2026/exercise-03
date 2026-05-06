package idh.java;

public class LeapYear {
	public boolean isLeapYear(int iYear) throws OutOfRangeException 
	{
		// The Gregorian calendar went into effect in October 1582
		if (iYear < 1582) 
		{
			throw new OutOfRangeException();
		}
	
		// Wenn sich das Jahr durch 4 teilen lässt, ist es ein Schaltjahr.
    	boolean b4teilbar = iYear % 4 == 0;
    	// Wenn sich das Jahr durch 100 teilen lässt, ist es kein Schaltjahr
    	boolean b100teilbar = iYear % 100 == 0;
    	// Wenn sich das Jahr durch 400 teilen lässt, ist es ein Schaltjahr.
    	boolean b400teilbar = iYear % 400 == 0;
    
    	return ( (b4teilbar && !b100teilbar) || b400teilbar );
	}
}