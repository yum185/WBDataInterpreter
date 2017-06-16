package exceptions;


public class MissingMachineCodeException extends Exception {
	  
	 
	private static final long serialVersionUID = 6703945554328759549L;
	private static final String exceptionMessage = "machineCode不存在";
	
	public MissingMachineCodeException(){
		super(exceptionMessage);
	}
 
}