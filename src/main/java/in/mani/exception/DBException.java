package in.mani.exception;

public class DBException extends RuntimeException {

	/**
	 * This Exception is for DB Exception
	 */
	private static final long serialVersionUID = 1L;

	public DBException(String message) {
		super(message);
	}

}
