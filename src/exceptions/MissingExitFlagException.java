package exceptions;


public class MissingExitFlagException extends Exception {
	   
	private static final long serialVersionUID = 5348604887813865184L;
	private static final String exceptionMessage = "exitFlag不存在";
	
	public MissingExitFlagException(){
		super(exceptionMessage);
	}
 
}
