package in.mani.exception;

public class ServiceException extends RuntimeException {

	/**
	 * This Exception is for Service Exception
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

}
