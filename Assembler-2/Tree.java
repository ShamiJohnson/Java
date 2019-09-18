
public class Tree {
	protected Tree Left;
	protected Tree Right;
	
	protected int Data;
	protected String Label;
	protected boolean isOperand;
	protected boolean hasData;
	
	public Tree()	// Default constructor
	{
		Left = null;
		Right = null;
		
		Data = 0;
		Label = null;
		isOperand = false;
		hasData = false;
	};
	
	public void set_Data(int Data)
	{	// Setter for Data
		this.Data = Data;
	};
		
	public Tree Add_Data(int Data)
	{	// Takes in new data, and adjusts the tree's structure
		// Returns Right sub-tree
		// TODO: Find bug when adding data to a an Operand Node
		if (!isOperand)
		{
			if (hasData)
			{
				Left = new Tree();	// Current data goes to left
				Left.set_Data(this.Data);

				Right = new Tree();	// New data to right
				Right.set_Data(Data);

				isOperand = true;	// Data is now an operand
				hasData = false;
				this.Data = 0;
				
				return this;
			}
			else
			{
				hasData = true;
				this.Data = Data;
				isOperand = false;
				
				return this;
			}
		}
		else
		{
			// Shift Root to Left Child
			Tree Temp = new Tree();
			Temp.isOperand = true;
			Temp.Left = this;
			Temp.Right = new Tree();
						
			// Move new data to Right child
			Temp.Right.Data = Data;
			Temp.Right.hasData = true;
			Temp.Right.isOperand = false;
			
			return Temp;
		}
	};
	
	public void Add_Operand(char Operand)
	{	//TODO: Handle Adding new Operands
		if (isOperand)
		{
			if (Right.Data == 0 && Right.isOperand)
				Right.Add_Operand(Operand);
			else
			{
				if (Data == 0)
					Data = Operand;
			}
		}
	};
	
	public int Evaluate()
	{	// Recursively navigates Tree
		// Returns evaluated value for entire tree
		if (isOperand)
		{
			switch (Data)
			{
			case '+':
				return Right.Evaluate() + Left.Evaluate();
			case '-':
				return Right.Evaluate() - Left.Evaluate();
			case '*':
				return Right.Evaluate() * Left.Evaluate();
			case '/':
				return Right.Evaluate() / Left.Evaluate();
			}
		}
		
		return Data;
	}
}
