import java.util.Scanner;

/**
 * utility class
 */
public class Utils {
	
	/**
	 * create new Scanner object
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * read an integer between minimum and maximum
	 * @param prompt
	 * @param min minimum
	 * @param max maximum
	 * @return value in range minimum, maximum inclusive
	 */
	public static int readInt(String prompt, int min, int max){
		
		int number;//valid number
		
		System.out.print(prompt);
		
		//loop until user enter an integer
		while (true){
			try{
				number = Integer.parseInt(scanner.nextLine());
				if (number < min || number > max){
					System.out.printf("Please enter number between %d and %d inclusive. Try again: ", min, max);
				}else{
					break;
				}
			}catch(NumberFormatException e){
				System.out.print("Invalid input. Try again: ");
			}//end try
		}//end while
		
		return number;
	}
	
	/**
	 * get the positions cells that knight can move to
	 * @param chessboard chess board 
	 * @param Q a position
	 * @return number of cells (not yet visited) and knight can move to
	 */
	public static SinglyLinkedList getNeighbors(int[][] chessboard, Position Q){
		
		SinglyLinkedList list = new SinglyLinkedList();
		
		//row and column of Q
		int i = Q.getRow();
		int j = Q.getColumn();
		
		if (isValid(chessboard, i - 2, j + 1) && chessboard[i - 2][j + 1] == -1){
			list.add(new Position(i - 2, j + 1));
		}
		if (isValid(chessboard, i - 1, j + 2) && chessboard[i - 1][j + 2] == -1){
			list.add(new Position(i - 1, j + 2));
		}
		if (isValid(chessboard, i + 1, j + 2) && chessboard[i + 1][j + 2] == -1){
			list.add(new Position(i + 1, j + 2));
		}
		if (isValid(chessboard, i + 2, j + 1) && chessboard[i + 2][j + 1] == -1){
			list.add(new Position(i + 2, j + 1));
		}
		if (isValid(chessboard, i + 2, j - 1) && chessboard[i + 2][j - 1] == -1){
			list.add(new Position(i + 2, j - 1));
		}
		if (isValid(chessboard, i + 1, j - 2) && chessboard[i + 1][j - 2] == -1){
			list.add(new Position(i + 1, j - 2));
		}
		if (isValid(chessboard, i - 1, j - 2) && chessboard[i - 1][j - 2] == -1){
			list.add(new Position(i - 1, j - 2));
		}
		if (isValid(chessboard, i - 2, j - 1) && chessboard[i - 2][j - 1] == -1){
			list.add(new Position(i - 2, j - 1));
		}

		return list;
	}
	
	/**
	 * check if row, column is valid indices
	 * @param chessboard chess board 
	 * @param row
	 * @param column
	 * @return valid or not
	 */
	public static boolean isValid(int[][] chessboard, int row, int column){
		return row >= 0 && row < chessboard.length && 
				column >= 0 && column < chessboard.length;
	}
}
