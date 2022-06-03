package main.exception;

public class FullQueueException extends IndexOutOfBoundsException {

	private static final long serialVersionUID = 1L;
	 
	
	public FullQueueException(String message) {
		super(message);
	}

}
