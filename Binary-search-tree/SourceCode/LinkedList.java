/**
 * LinkedList implements a singly linked list
 * Each node contains an integer
 * and a reference to next node or null if it is tail node.
 */
public class LinkedList {
	
	/**
	 * linked list node
	 */
	class LinkedListNode {
		
		/**
		 * data of node
		 */
		private int data;
		
		/**
		 * reference to next node
		 */
		private LinkedListNode next;

		/**
		 * constructor
		 * @param data data of node
		 */
		public LinkedListNode(int data) {
			this.data = data;
		}

		/**
		 * getter of data
		 * @return the data
		 */
		public int getData() {
			return data;
		}

		/**
		 * setter of data
		 * @param data the data to set
		 */
		public void setData(int data) {
			this.data = data;
		}

		/**
		 * get the reference to next node
		 * @return reference to next node
		 */
		public LinkedListNode getNext() {
			return next;
		}

		/**
		 * setter of next
		 * @param next reference to next node
		 */
		public void setNext(LinkedListNode next) {
			this.next = next;
		}
	}
	
	/**
	 * reference to head node
	 */
	private LinkedListNode head;
	
	/**
	 * add data to the list that maintains the order
	 * @param item data
	 */
	public void add(int item) {
		
		//create new node
		LinkedListNode newNode =  new LinkedListNode(item);
		
		if (head == null) { //empty list
			head = newNode;
		} else {
			//find appropriate position to insert new node
			LinkedListNode tempNode = head;
			LinkedListNode prevNode = null;//previous node of tempNode
			while(tempNode != null && tempNode.getData() < item){
				prevNode = tempNode;
				tempNode = tempNode.getNext();
			}
			
			//duplicate item, ignore
			if (tempNode != null && tempNode.getData() == item){
				return;
			}
			
			//new node has head node
			if (prevNode == null){
				newNode.setNext(head);
				head = newNode;
			}else{//new node is next node of prevNode
				prevNode.setNext(newNode);
				newNode.setNext(tempNode);
			}
		}
	}
	
	/**
	 * output data in linked list in String format
	 */
	public String toString(){
		
		String info = "";
		
		//iterate the list
		LinkedListNode tempNode = head;
		while(tempNode != null){
			info += String.format("%-5d", tempNode.getData());
			tempNode = tempNode.getNext();
		}
		
		return info.trim();
	}
}

