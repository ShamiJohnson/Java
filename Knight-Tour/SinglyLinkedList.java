/**
 * The class implements the singly link list
 * that contains nodes
 * Each node has data and the reference to next node 
 * (or null)
 * 
 */
public class SinglyLinkedList {
	
	/**
	 * node in linked list
	 */
	private class Node{
		
		/**
		 * data of node
		 */
		Object data;
		
		/**
		 * reference to next node
		 */
		Node next;

		/**
		 * constructor
		 * @param data an element
		 */
		public Node(Object data) {
			this.data = data;
		}		
	}
	
	/**
	 * head node of singly linked list
	 */
	private Node head;
	
	/**
	 * add an element to end of list
	 * @param e new element
	 */
	public void add(Object e){
		if (head == null){
			head = new Node(e);
		}else{
			Node current = head;
			
			//iterate the list
			while (current.next != null){
				current = current.next;
			}
			
			//insert as tail node
			current.next = new Node(e);
		}
	}
	
	/**
	 * add an element to head of list
	 * @param e new element
	 */
	public void addToHead(Object e){
		if (head == null){
			head = new Node(e);
		}else{
			Node newNode = new Node(e);
			newNode.next = head;
			head = newNode;
		}
	}
	
	/**
	 * remove the first element in the linked list.
	 * @return first element or null if list is empty
	 */
	public Object removeFirst() {
		if (head == null) {
			return null;
		} else {
			Object element = head.data;
			
			//move head to next node
			head = head.next;
			return element;
		}
	}
	
	/**
	 * get element at index, return null if index is invalid.
	 * @return element or null if index is invalid
	 */
	public Object get(int index) {
		if (index < 0 || index >= size()){
			return null;
		}
		
		Node current = head;
		
		//iterate the list to get object at index
		for (int i = 0; i < index; i++){
			current = current.next;
		}
		
		return current.data;
	}
	
	/**
	 * get the data at first node
	 * @return first element or null if list is empty
	 */
	public Object first() {
		if (head == null) {
			return null;
		} else {
			return head.data;
		}
	}
	
	/**
	 * check if element existing in the list
	 * @param element element to check
	 * @return true if exists; otherwise, return false
	 */
	public boolean contains(Object element) {
		Node current = head;
		
		//iterate the list to find
		while (current != null && !current.data.equals(element)){
			current = current.next;
		}
		
		//if current is not null, it contains element
		return current != null;
	}
	
	/**
	 * get the number of elements in list
	 * @return the number of elements in list
	 */
	public int size(){
		int numElements = 0;//number of elements
		
		Node current = head;
		
		//iterate the list
		while (current != null){
			numElements++;
			current = current.next;
		}
		
		return numElements;
	}
	
	/**
	 * remove element
	 * @param element element to remove
	 * @return true if element in list; otherwise, return false
	 */
	public boolean remove(Object element) {
		
		boolean found = false; //element in list?
		
		Node prev = null;      //previous node of current
		Node current = head;
		
		//iterate the list
		while (current != null && !current.data.equals(element)){
			prev = current;
			current = current.next;
		}
		
		if (current != null){//found
			found = true;
			
			//remove node
			if (prev == null){//remove head node
				head = head.next;
			}else{
				prev.next = current.next;//set the link to remove current
			}
		}
		
		return found;
	}
	
	/**
	 * check if list is empty
	 * @return true if list is empty; otherwise, return false
	 */
	public boolean isEmpty(){
		return head == null;
	}
}
