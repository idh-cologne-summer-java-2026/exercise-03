package idh.java;

public class LeapYear {

    public boolean isLeapYear(int year) throws OutOfRangeException {
    	
    	
  
    	     if (year < 1582) {
    	            throw new OutOfRangeException();
    	        }

    	        if (year % 400 == 0) {
    	            return true;
    	        }

    	        if (year % 100 == 0) {
    	            return false;
    	        }

    	        if (year % 4 == 0) {
    	            return true;
    	        }

    	        return false;
    	    }
    	}

      
