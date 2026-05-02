package idh.java;

public class Main {

	public static void main(String[] args){
		
		LeapYear leapYearObject = new LeapYear();
		try {
			leapYearObject.isLeapYear(1983);
		} catch (OutOfRangeException e) {
			System.out.println("Zu dieser Zeit gab es noch keine Schaltjahre!");
			e.printStackTrace();
		}

	}


}
