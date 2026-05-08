package idh.java;

public class OutOfRangeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/*constructor added in order to allow for an error message */
	public OutOfRangeException(String message) {
        super(message);
	}

}
