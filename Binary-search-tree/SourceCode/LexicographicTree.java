import java.io.BufferedWriter;
import java.io.IOException;

/**
 * LexicographicTree represents a binary search tree
 * Each node is TreeNode that store key (word),
 * the list of integer as lines
 * and references to left and right child
 */
public class LexicographicTree{
	
	/**
	 * TreeNode class represents a node in tree
	 */
	class TreeNode{
		
		String word; //key of node
		LinkedList lines; //lines of this word
		
		TreeNode leftChild; //reference to left child
		TreeNode rightChild;//reference to right child
		
		/**
		 * constructor
		 * 
		 * initialize the node with item. The left and right references are set to null
		 * 
		 * @param item key of node
		 * @param line line number
		 */
		public TreeNode(String item, int line){
			word = item;
			lines = new LinkedList();
			lines.add(line);
			
			leftChild = null;
			rightChild = null;
		}//end constructor
		
		/**
		 * constructor
		 * 
		 * initialize the node with item, left and right references
		 * 
		 * @param item key of node
		 * @param line line number
		 * 
		 * @param left
		 * @param right
		 */
		public TreeNode(String item, int line, TreeNode left, TreeNode right){
			word = item;
			lines = new LinkedList();
			lines.add(line);
			
			leftChild = left;
			rightChild = right;
		}//end constructor		
		
		/**
		 * return a string represent word with its lines
		 */
		public String toString(){
			return String.format("%-15s", word) + " " + lines;
		}
	}
	
	/**
	 * root of tree
	 */
	private TreeNode root = null;

	/**
	 * add item to the tree
	 * 
	 * precondition: none
	 * postcondition: item is added
	 * 
	 * @param item key of node
	 * @param line line number
	 */
	public void add(String item, int line){
		if (root == null){
			root = new TreeNode(item, line);
		}else{
			add(root, item, line);
		}
	}//end add
	
	/**
	 * add item to the recursive helper method
	 * 
	 * precondition: current is not null
	 * postcondition: item is added
	 * 
	 * @param current root of current tree
	 * @param item item to add
	 * @param line line number
	 */
	private void add(TreeNode current, String item, int line){
		if (current.word.compareTo(item) > 0){ //item is less than current, add to left
			if (current.leftChild == null){ //add as left child of current
				current.leftChild = new TreeNode(item, line);
			}else{//call recursive
				add(current.leftChild, item, line);
			}//end if else
		}else if (current.word.compareTo(item) < 0){ //item is greater than current, add to right
			if (current.rightChild == null){//add as right child
				current.rightChild = new TreeNode(item, line);
			}else{//call recursive
				add(current.rightChild, item, line);
			}//end if else
		}else{//duplicate
			current.lines.add(line);
		}//end if else
	}//end add
	
	/**
	 * inorder traversal
	 * 
	 * precondition: none
	 * postcondition:  tree is printed to buffer writer
	 * 
	 * @param bufferedWriter buffered writer
	 * @throws IOException if could not write
	 */
	public void inorder(BufferedWriter bufferedWriter) throws IOException{
		inorder(root, bufferedWriter);
	}//end inorder
	
	/**
	 * inorder traversal
	 * 
	 * precondition: none
	 * postcondition:  tree is printed to buffer writer
	 * 
	 * @param current root of current tree
	 * 
	 * @param bufferedWriter buffered writer
	 * @throws IOException if could not write
	 */
	private void inorder(TreeNode current, BufferedWriter bufferedWriter) throws IOException{
		if (current != null){			
			inorder(current.leftChild, bufferedWriter);
			bufferedWriter.write(current + "\n");
			inorder(current.rightChild, bufferedWriter);
		}
	}//end System.out.print(current);
		
}//end LexicographicTree
