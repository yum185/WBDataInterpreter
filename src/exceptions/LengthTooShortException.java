package exceptions;

 

public class LengthTooShortException extends Exception {
	
	private static final long serialVersionUID = -6239227873958183335L;
	private static final String exceptionMessage = "byte数组长度不足";
	
	public LengthTooShortException(){
		super(exceptionMessage);
	}
 
}
