package exceptions; 
  

public class MissingAppIdException extends Exception {
	 
	private static final long serialVersionUID = 8669208647673909539L;
	private static final String exceptionMessage = "appId不存在";
	
	public MissingAppIdException(){
		super(exceptionMessage);
	}
 
}
