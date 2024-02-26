
public class Notation {
	public static String convertInfixToPostfix(String in) throws InvalidNotationFormatException{
		MyQueue<String> queue = new MyQueue<String>(in.length());
		MyStack<String> stack = new MyStack<String>(in.length());
		
		try {
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == ' ') {
				continue;
			}
			else if (Character.isDigit(in.charAt(i))){
				queue.enqueue("" + in.charAt(i));
			}
			else if (in.charAt(i) == '('){
				stack.push(Character.toString(in.charAt(i)));
			}
			else if (in.charAt(i) == '+'){
				if (!stack.isEmpty()) {
					while (!stack.isEmpty() && (stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/"))) {
						queue.enqueue(stack.pop());
					}	
				}
				stack.push(Character.toString(in.charAt(i)));
			}
			else if (in.charAt(i) == '-'){
				if (!stack.isEmpty()) {
					while (!stack.isEmpty() && (stack.top().equals("+") || stack.top().equals("-") || stack.top().equals("*") || stack.top().equals("/"))) {
						queue.enqueue(stack.pop());
					}	
				}
				stack.push(Character.toString(in.charAt(i)));
			}
			else if (in.charAt(i) == '*'){
				if (!stack.isEmpty()) {
					while (!stack.isEmpty() && (stack.top().equals("*") || stack.top().equals("/"))) {
						queue.enqueue(stack.pop());
					}	
				}
				stack.push(Character.toString(in.charAt(i)));
			}
			else if (in.charAt(i) == '/'){
				if (!stack.isEmpty()) {
					while (!stack.isEmpty() && (stack.top().equals("*") || stack.top().equals("/"))) {
						queue.enqueue(stack.pop());
					}	
				}
				stack.push(Character.toString(in.charAt(i)));
			}
			else if (in.charAt(i) == ')'){
				while (!stack.isEmpty() && !stack.top().equals("(")) {
					queue.enqueue(stack.pop());
				}
				if (stack.isEmpty() || !stack.top().equals("(")) {
					throw new InvalidNotationFormatException();
				}
				stack.pop();
			}
		}
		while (!stack.isEmpty()) {
		    queue.enqueue(stack.pop());
		}
		}
		catch (Exception e){
            throw new InvalidNotationFormatException();
        } 
		return queue.toString();
	}
	
	public static String convertPostfixToInfix(String in) throws InvalidNotationFormatException{
		MyStack<String> stack = new MyStack<String>();
		
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == ' ') {
				continue;
			}
			else if (Character.isDigit(in.charAt(i))) {
				stack.push("" + in.charAt(i));
			}
			else if (in.charAt(i) == '+' || in.charAt(i) == '-' || in.charAt(i) == '*' || in.charAt(i) == '/') {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				else {
					String val1 = stack.pop();
					String val2 = stack.pop();
					String str = "(" + val2 + in.charAt(i) + val1 + ")";
					stack.push(str);
				}
			}
		}
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		else {
			return stack.toString();
		}
	}
	
	public static double evaluatePostfixExpression(String in) throws InvalidNotationFormatException{
		MyStack<String> stack = new MyStack<String>();
		
		for (int i = 0; i < in.length(); i++) {
			if (in.charAt(i) == ' ') {
				continue;
			}
			else if (Character.isDigit(in.charAt(i)) || in.charAt(i) == '(') {
				stack.push("" + in.charAt(i));
			}
			else if (in.charAt(i) == '+' || in.charAt(i) == '-' || in.charAt(i) == '*' || in.charAt(i) == '/') {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				else {
					char operation = in.charAt(i);
					String holder1 = stack.pop();
					String holder2 = stack.pop();
					double calculation = 0;

					switch(operation) {
					case '+': calculation = Double.parseDouble(holder2) + Double.parseDouble(holder1);
					break;
					case '-': calculation = Double.parseDouble(holder2) - Double.parseDouble(holder1);
					break;
					case '*': calculation = Double.parseDouble(holder2) * Double.parseDouble(holder1);
					break;
					case '/': calculation = Double.parseDouble(holder2) / Double.parseDouble(holder1);
					break;
					}
					stack.push("" + calculation);
					
				}
			}
		}
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		else {
			return Double.parseDouble(stack.pop());
		}
	}
}
