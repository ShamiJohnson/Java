/**
 * Position represent a position 
 */
public class Position{
	
	/**
	 * row
	 */
	private int row;
	
	/**
	 * column
	 */
	private int column;
	
	/**
	 * constructor
	 * @param row row
	 * @param column column
	 */
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	/**
	 * getter of row
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * setter of row
	 * @param row the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * getter of column
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * setter of column
	 * @param column the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	//compare two positions by (row, column) pairs
	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return (column == other.column && row == other.row);
	}

	@Override
	public String toString() {
		return row + ", " + column;
	}
	
}
