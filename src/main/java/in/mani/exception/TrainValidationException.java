package in.mani.exception;

public class TrainValidationException extends RuntimeException {
	
	/**
	 * This Exception is for Invalid Details
	 */
	private static final long serialVersionUID = 1L;

	public TrainValidationException(String message) {
		super(message);
	}
}
