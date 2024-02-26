
public class StackUnderflowException extends RuntimeException {
	public StackUnderflowException()
	{
		super("Stack is empty");
	}
	public StackUnderflowException(String message) {
		super(message);
	}
}
