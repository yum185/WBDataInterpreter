package exceptions;


public class MissingTimestampException extends Exception {
	 
	private static final long serialVersionUID = -2391078892836147481L;
	private static final String exceptionMessage = "timestamp不存在";
	
	public MissingTimestampException(){
		super(exceptionMessage);
	}
 
}
