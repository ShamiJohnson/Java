/**
 * Warnsdorff's algorithm
 * that solves the number of steps
 * in Knight's tour problem
 * 
 * Input: initial position, empty chess board 
 * Output: chess board is loaded with number of steps: 1, 2,...
 */
public class WarnsdorffAlgorithm {
	
	/**
	 * initial position
	 */
	private Position initialPosition;
	
	/**
	 * chess board
	 */
	private int[][] chessboard;
	
	/**
	 * number of steps
	 * 
	 * <= 64
	 */
	private int numSteps;
	
	/**
	 * last position in this algorithm
	 */
	private Position lastPostion;
	
	/**
	 * constructor
	 * 
	 * @param initialPosition initial position
	 * @param chessboard reference to chess board
	 * @param numSteps number of steps
	 */
	public WarnsdorffAlgorithm(Position initialPosition, int[][] chessboard, int numSteps){
		this.initialPosition = initialPosition;
		this.chessboard = chessboard;
		this.numSteps = numSteps;
	}
	
	/**
	 * solve the problem
	 * 
	 * algorithm:
	 * 
	 * Set P is initial position on the board
	 * Set location of P is 1 in the chess board
	 * do
	 *    Choose P is the minimum position from set of positions accessible from P 
	 * until number of steps
	 */
	public void solve(){
		Position P = initialPosition;
		int move = 1; //current move
		
		chessboard[P.getRow()][P.getColumn()] = move;
		move++;
		lastPostion = P;
		
		for (int i = 1; P != null && i < numSteps; i++){
			P = getMin(P);
			if (P != null){
				chessboard[P.getRow()][P.getColumn()] = move;
				move++;
				
				lastPostion = P;
			}
		}
	}	
	
	/**
	 * get the minimum position from set of positions accessible from P 
	 * @param P a position
	 * @return position with minimum accessibility
	 */
	public Position getMin(Position P){
		Position min = null;
		int minNeighboards = 0;
		
		SinglyLinkedList neighbors = Utils.getNeighbors(chessboard, P);
		while (!neighbors.isEmpty()){
			Position pos = (Position)neighbors.removeFirst();
			int numNeighbors = countNeighbors(pos);
			if (min == null || minNeighboards > numNeighbors){
				min = pos;
				minNeighboards = numNeighbors;
			}
		}
		
		return min;
	}
	
	/**
	 * get the number of cells that knight can move to 
	 * @param Q a position
	 * @return number of cells (not yet visited) and knight can move to
	 */
	public int countNeighbors(Position Q){
		return Utils.getNeighbors(chessboard, Q).size();	
	}
	
	/**
	 * get last position
	 * @return the lastPostion
	 */
	public Position getLastPostion() {
		return lastPostion;
	}
}
