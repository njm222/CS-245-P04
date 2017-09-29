
public class ArrayStack implements Stack {
	
	private Object[] stack;
	private int tail;
	private static int arrSize = 10;
	
	public ArrayStack() {
		stack = new Object[arrSize];
		emptyArr();
	}
	
	private void emptyArr() {
		// TODO Auto-generated method stub
		tail = -1;
	}

	public void push(Object item) {
		// TODO Auto-generated method stub
		if(tail == stack.length-1)
			grow_Stack();
		
		stack[++tail] = item;
	}

	private void grow_Stack() {
		// TODO Auto-generated method stub
		Object[] temp = new Object[stack.length*2];
		
		System.arraycopy(stack, 0, temp, 0, stack.length);
		stack = temp;
	}

	public Object pop() {
		// TODO Auto-generated method stub
		if(empty())
			return null;
		
		Object temp = stack[tail--];
		return temp;
	}

	public Object peek() {
		// TODO Auto-generated method stub
		if(empty())
			return null;
		Object temp = stack[tail];
		return temp;
	}

	public boolean empty() {
		// TODO Auto-generated method stub
		if(tail == -1)
			return true;
		return false;
	}

}
