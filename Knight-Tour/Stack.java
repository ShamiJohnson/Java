/**
 * Stack class represents the stack by using
 * SinglyListList
 * It uses the head node of SinglyListList object
 * as the top node of stack
 * 
 */
public class Stack{
	
	/**
	 * stack data
	 */
	private SinglyLinkedList data = new SinglyLinkedList();
	
	/**
	 * retrieve, not remove the top of stack
	 * @return data at top or null if stack is empty
	 */
	public Object peek(){
		return data.first();
	}
	
	/**
	 * retrieve, and remove the top of stack
	 * @return data at top or null if stack is empty
	 */
	public Object pop(){
		return data.removeFirst();
	}
	
	/**
	 * push an element to stack
	 * 
	 * @param e
	 */
	public void push(Object e){
		//put element as the first node of linked list
		data.addToHead(e);
	}
	
	/**
	 * get the number of elements in stack
	 * @return the number of elements in stack
	 */
	public int size(){
		return data.size();
	}
	
	/**
	 * check if stack is empty
	 * @return true if stack is empty; otherwise, return false
	 */
	public boolean isEmpty(){
		return data.isEmpty();
	}
}
