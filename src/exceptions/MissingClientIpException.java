package exceptions;


public class MissingClientIpException extends Exception {
	  
	private static final long serialVersionUID = -5633427326266084730L;
	private static final String exceptionMessage = "clientIp不存在";
	
	public MissingClientIpException(){
		super(exceptionMessage);
	}
 
}
