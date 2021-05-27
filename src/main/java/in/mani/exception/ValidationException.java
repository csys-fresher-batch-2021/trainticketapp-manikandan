package in.mani.exception;

public class ValidationException extends RuntimeException {

	/**
	 * This Exception is for Validation Exception
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}
}
