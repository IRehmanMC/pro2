import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface <T> {
	private int size;
	private ArrayList<T> queueList;
	
	public MyQueue(int in) { 
		size = in; 
		queueList = new ArrayList<>(in); 
	}
	public MyQueue() { 
		queueList = new ArrayList<>(); 
	}
	public boolean isEmpty() {
	    return queueList.isEmpty();
	}
	public boolean isFull() {
        return queueList.size() == size;
    }
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return queueList.remove(0);
    }
	public int size() {
		return queueList.size();
	}
	public boolean enqueue(T e) throws QueueOverflowException {
	    if (isFull()) {
	        throw new QueueOverflowException();
	    }
	    return queueList.add(e);
	}
	public String toString() {
        String str = "";
        for (int i = 0; i < size(); i++) {
            str += queueList.get(i);
        }
        return str;
    }
	public String toString(String delimiter) {
		String str = "";
		for (int i = 0; i < queueList.size(); i++)
			str += delimiter + queueList.get(i);
		return str;
	}
	public void fill(ArrayList<T> list) throws QueueOverflowException {
	    if (list.size() > size) {
	        throw new QueueOverflowException("List size exceeds queue size!");
	    }
		for (int i = 0; i < list.size(); i++)
		{
				enqueue(list.get(i));
		}
	}
}

