
public class ArrayQueue implements Queue {
	
	private Object[] queue;
	private int currSize;
	private int head;
	private int tail;
	private static int arrSize = 10;
	
	public ArrayQueue() {
		queue = new Object[arrSize];
        emptyArr();
	}

	private void emptyArr() {
		// TODO Auto-generated method stub
		currSize = 0;
		head = 0;
		tail = -1;	
	}

	public Object dequeue() {
		// TODO Auto-generated method stub
		if( empty())
			return null;
		
		currSize--;
		Object temp = queue[head];
		queue[head] = null;
		head = increment(head);
		
		return temp;
	}

	private int increment(int i) {
		// TODO Auto-generated method stub
		if(++i == queue.length)
			i = 0; //increment queue length
		return i;
	}

	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if(isFull())
			grow_Queue();
		
		tail = increment(tail);
		queue[tail] = item;
		currSize++;
	}

	private void grow_Queue() {
		// TODO Auto-generated method stub
		Object[] temp = new Object[queue.length*2];
		
		
		if(head < tail){
			//copy array if tail comes after the head
			System.arraycopy(queue, 0, temp, 0, queue.length);
		}
		else{
			//copies array from head to the end of the Object array
			System.arraycopy(queue, head, temp, 0, head-tail);
			//copies array from the start of the Object array to the tail
			System.arraycopy(queue, 0, temp, head-tail, queue.length-head-tail);
		}
		
		//reset pointers
		head = 0;
		tail = queue.length-1;
		
		queue = temp;
	}

	private boolean isFull() {
		// TODO Auto-generated method stub
		if(currSize == queue.length)
			return true;
		return false;
	}

	public boolean empty() {
		// TODO Auto-generated method stub
		if(currSize == 0)
			return true;
		return false;
	}

}
