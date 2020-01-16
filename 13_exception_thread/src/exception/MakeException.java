package exception;

public class MakeException extends Exception{
	
	private String errorMsg;
	public MakeException() {
	}
	
	public MakeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
//		return getClass() + ":" + errorMsg;
		return errorMsg;
	}
	
	
}
