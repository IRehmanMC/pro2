
public class StackOverflowException extends RuntimeException {
	public StackOverflowException()
	{
		super("Stack is full");
	}
	public StackOverflowException(String message) {
		super(message);
	}
}
