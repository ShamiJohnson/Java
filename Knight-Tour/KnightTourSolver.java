/**
 * CSCI 36200: Data Structures
 * Programming Assignment 1
 * Instructor: Dr. Snehasis Mukhopadhyay
 * 
 * Due date: February 15, 2018
 * 
 * The program uses Warnsdorff Algorithm for 32 steps
 * then uses backtracking with stack to solve the remaining steps
 * 
 * 
 */
public class KnightTourSolver {

	/**
	 * 8 x 8 chess board
	 */
	private static final int SIZE = 8;
	
	/**
	 * apply Warndoff's heuristic for the first 32 moves
	 */
	private static final int NUM_MOVES = 32;
	
	/**
	 * chess board
	 */
	private int[][] chessboard = new int[SIZE][SIZE];
	
	/**
	 * constructor
	 */
	public KnightTourSolver(){
		initialize();
	}
	
	/**
	 * print chess board
	 */
	public void printChessboard(){
		for (int r = 0; r < SIZE; r++){
			for (int c = 0; c < SIZE; c++){
				System.out.printf("%4d", chessboard[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * solve the problem
	 * by moving by Warnsdorff Algorithm
	 * and use backtracking (Stack)
	 */
	public void solve(SinglyLinkedList initialPositions){
		
		//get the positions from list and solve one by one
		Position initialPosition = (Position)initialPositions.removeFirst();
		while (initialPosition != null){
			
			WarnsdorffAlgorithm alg = new WarnsdorffAlgorithm(initialPosition, chessboard, NUM_MOVES);
			alg.solve();

			//use backtracking for remaining steps
			Position current = alg.getLastPostion();
			int moves = NUM_MOVES + 1;
			
			Stack stack = new Stack();
			
			//add neighbors to stack
			SinglyLinkedList neighbors = Utils.getNeighbors(chessboard, current);
			while (!neighbors.isEmpty()){
				Position pos = (Position)neighbors.removeFirst();
				stack.push(pos);
			}
			
			//run the algorithm
			while (!stack.isEmpty() && !isFull()){
				
				current = (Position)stack.pop();
				
				//do not check again, all paths have failed
				if (chessboard[current.getRow()][current.getColumn()] != -1){
					chessboard[current.getRow()][current.getColumn()] = -1;
					moves--;
					continue;
				}
				
				chessboard[current.getRow()][current.getColumn()] = moves;
				moves++;
				
				//printChessboard();
				
				//solution found?
				if (isFull()){
					break;
				}
				//get its neighbors
				neighbors = Utils.getNeighbors(chessboard, current);
				if (neighbors.size() == 0){ //can not move more
					chessboard[current.getRow()][current.getColumn()] = -1;
					moves--;
				}else{
					
					stack.push(current);
					
					//try with next cell
					while (!neighbors.isEmpty()){
						Position pos = (Position)neighbors.removeFirst();
						stack.push(pos);
					}
				}
			}
			
			//print initial position
			System.out.printf("Initial position: row = %d, column = %d\n",
					initialPosition.getRow() + 1, initialPosition.getColumn() + 1);		
			
			if (isFull()){
				//print chess board
				printChessboard();
			}else{
				System.out.println("Solution not found!");
			}

			//next initial position
			initialPosition = (Position)initialPositions.removeFirst();
			
			//clear chess board
			initialize();
		}
		
		
	}
	
	/**
	 * check if chess board is loaded with all knight moves
	 * @return
	 */
	private boolean isFull(){
		//iterate each cells and check empty
		for (int r = 0; r < SIZE; r++){
			for (int c = 0; c < SIZE; c++){
				if (chessboard[r][c] == -1){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * initialize the chess board with -1
	 */
	public void initialize(){
		for (int r = 0; r < SIZE; r++){
			for (int c = 0; c < SIZE; c++){
				chessboard[r][c] = -1;
			}
		}
	}
	
	/**
	 * print list
	 * @param initialPositions
	 */
	private static void printList(SinglyLinkedList initialPositions){
		
		if (initialPositions.size() == 0){
			System.out.println("The initial positions list is empty");
			System.out.println("");
			return;
		}
		
		System.out.println("Current initial positions: ");
		//print list
		int size = initialPositions.size();
		for (int i = 0; i < size; i++){
			Position pos = (Position)initialPositions.get(i);
			System.out.printf("%d. (row = %d, column = %d)\n", i + 1, 
					pos.getRow() + 1, pos.getColumn() + 1);
		}		
		System.out.println("");
	}
	
	/**
	 * display menu
	 */
	private static int menu(){
		System.out.println("1. add");
		System.out.println("2. edit");
		System.out.println("3. remove");
		System.out.println("4. exit");
		
		return Utils.readInt("Please enter your selection? ", 1, 4);
	}
	
	/**
	 * add, delete, or modify the list of initial positions
	 *  
	 * @param initialPositions initial positions
	 */
	public static void manageInitialPositions(SinglyLinkedList initialPositions){
		
		//position information
		int row, column;
		Position pos;
		Position newPos; //modified position
		int index; //chosen index of position
		
		//print list
		printList(initialPositions);
		
		//menu
		int selection = menu();
		while (selection != 4){
			
			switch(selection){
			case 1: //add
				
				row = Utils.readInt("Please enter row index [1-8]. Enter 0 to exit: ", 0, 8);
				if (row == 0){
					break;
				}
				column = Utils.readInt("Please enter column index [1-8]. Enter 0 to exit: ", 0, 8);
				
				if (column == 0){
					break;
				}
				pos = new Position(row - 1, column - 1);
				if (initialPositions.contains(pos)){
					System.out.println("You entered that position already");
				}else{
					initialPositions.add(pos);
				}
				
				break;
			case 2://edit
				
				if (initialPositions.size() == 0){
					System.out.println("There is no initial position. Please add the initial position");
				}else{
					
					//print list
					printList(initialPositions);
					
					index = Utils.readInt("Please enter a position: ", 1, initialPositions.size());
					pos = (Position)initialPositions.get(index - 1);
					
					row = Utils.readInt("Please enter row index [1-8]. Enter 0 to exit: ", 0, 8);
					if (row == 0){
						break;
					}
					column = Utils.readInt("Please enter column index [1-8]. Enter 0 to exit: ", 0, 8);
					
					if (column == 0){
						break;
					}
					
					//different row, column
					if (pos.getRow() != row - 1 || pos.getColumn() != column - 1){
						newPos = new Position(row - 1, column - 1);
						
						if (initialPositions.contains(newPos)){
							System.out.println("You entered that position already");
						}else{
							pos.setRow(row - 1);
							pos.setColumn(column - 1);
						}
					}					
				}
				break;
			case 3: //remove
				
				//print list
				printList(initialPositions);
				
				index = Utils.readInt("Please enter a position", 1, initialPositions.size());
				pos = (Position)initialPositions.get(index - 1);
				initialPositions.remove(pos);
				break;				
			}
			
			//print list
			printList(initialPositions);
			
			//next selection
			selection = menu();
		}
	}
	
	/**
	 * main method 
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		//create KnightTourSolver
		KnightTourSolver solver = new KnightTourSolver();
		
		//list of initial positions
		SinglyLinkedList initialPositions = new SinglyLinkedList();
		
		//read initial positions
		while (true){
			int row = Utils.readInt("Please enter row index [1-8]. Enter 0 to exit: ", 0, 8);
			if (row == 0){
				break;
			}
			int column = Utils.readInt("Please enter column index [1-8]. Enter 0 to exit: ", 0, 8);
			
			if (column == 0){
				break;
			}
			Position pos = new Position(row - 1, column - 1);
			if (initialPositions.contains(pos)){
				System.out.println("You entered that position already");
			}else{
				initialPositions.add(pos);
			}
		}//end read positions
		
		System.out.println();
		
		//edit list
		manageInitialPositions(initialPositions);
		
		if (initialPositions.size() == 0){
			System.out.println("There is no initial position");
		}else{		
			//solve the problem
			solver.solve(initialPositions);
		}
	}

}
