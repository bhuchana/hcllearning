package hcl.com.learning.timetracking.exception;

public class MissingHeaderInfoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MissingHeaderInfoException(String message) {
		super(message);
	}
}
