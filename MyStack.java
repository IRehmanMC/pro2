import java.util.ArrayList;

public class MyStack <T> implements StackInterface <T> {
    private int size;
    private ArrayList<T> stackList;
    
    public MyStack(int in) {
        size = in;
        stackList = new ArrayList<>(in);
    }
    public MyStack() {
        stackList = new ArrayList<>();
    }
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    public boolean isFull() {
        return stackList.size() >= 100;
    }
    public T pop() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stackList.remove(stackList.size() - 1);
    }
    public T top() throws StackUnderflowException {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stackList.get(stackList.size() - 1);
    }
    public int size() {
        return stackList.size();
    }
    public boolean push(T e) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException();
        }
        stackList.add(e);
        return true;
    }
	public String toString() {
        String str = "";
        for (int i = 0; i < size(); i++) {
            str += stackList.get(i);
        }
        return str;
    }
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < stackList.size(); i++)
			str += delimiter + stackList.get(i);
		return str;
	}
	public void fill(ArrayList<T> list) throws StackOverflowException {
	    if (list.size() > size) {
	        throw new StackOverflowException("List size exceeds stack size!");
	    }
		for (int i = 0; i < list.size(); i++)
		{
			push(list.get(i));
		}
	}
}
