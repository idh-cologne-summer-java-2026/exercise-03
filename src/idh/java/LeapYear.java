package idh.java;

public class LeapYear {
	
	public boolean isLeapYear(int year) throws OutOfRangeException  {
		
		if (year < 1582) {
			throw new OutOfRangeException("Das Jahr " + year + " liegt vor der Einführung der aktuellen Schaltjahrregelung durch Papst Gregor XIII.");
		}
			
		boolean isLeapYear;
		
	    if (year % 400 == 0) {
	        isLeapYear = true;
	      } else if (year % 100 == 0) {
	        isLeapYear = false;
	      } else if (year % 4 == 0) {
	        isLeapYear = true;
	      } else {
	        isLeapYear = false;
	      }
		return isLeapYear;
	    }
	
	public static void main(String[] args) throws OutOfRangeException {
		LeapYear leapYearObject = new LeapYear();
		int year = -2026;
		
		try {
			leapYearObject.isLeapYear(year);
			boolean isLeapYear = leapYearObject.isLeapYear(year);
				if(isLeapYear) {
					System.out.println("Beim Jahr " + year + " handelt es sich um ein Schaltjahr.");
				} else {
					System.out.println("Beim Jahr " + year + " handelt es sich nicht um ein Schaltjahr.");
				}	
		    } catch (OutOfRangeException e) {
		    	System.out.println(e.getMessage());
		    }
	}
}
