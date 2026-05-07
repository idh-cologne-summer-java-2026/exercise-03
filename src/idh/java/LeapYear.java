package idh.java;

public class LeapYear 
{
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
	
	public void print(int iYear) 
	{
		try 
		{
			System.out.print("Das Jahr "+iYear);
			if(isLeapYear(iYear))
				System.out.println(" ist ein Schaltjahr.");
			else
				System.out.println(" ist kein Schaltjahr.");
			System.out.println("=======");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		LeapYear outputLeapYear = new LeapYear();
		
		outputLeapYear.print(1982);
		outputLeapYear.print(1984);
		outputLeapYear.print(2000);
		outputLeapYear.print(2028);
		outputLeapYear.print(202000);
		
		outputLeapYear.print(1983);
		outputLeapYear.print(2026);
		outputLeapYear.print(1999);
		outputLeapYear.print(1998);
		outputLeapYear.print(1997);
		outputLeapYear.print(1900);
	};
}