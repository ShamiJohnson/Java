import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ControlSection {
	// Control Section is a collection of blocks, acts like a super-block

	private SymTable Local_Labels;
	private SymTable Global_Labels_XDEF;
	private SymTable Global_Labels_XREF;

	private ArrayList<ProgramBlock> Blocks;
	private int Current_Block;
	
	private String code_output;
	private String label_output;
	
	private boolean new_block;

	public ControlSection(String input)
	{
		this.code_output = input + "_interm.txt";
		this.label_output = input + "_labels.txt";
		
		Local_Labels = null;
		Global_Labels_XDEF = null;
		Global_Labels_XREF = null;

		Blocks = new ArrayList<ProgramBlock>();
		Blocks.add(new ProgramBlock(input + ".txt"));

		Current_Block = 0;
		new_block = false;
	}

	public boolean Loop(String[] line)
	{
		boolean error_state = false;

		//	Check for XDEF or XREF labels
		// 		Make a note of all labels called here

		//	IF finds "USE" directive, search created blocks for Arg
		//		If not found, create new Block
		//			increment Indexed_Blocks
		//			add another location counter, assume all blocks begin at 0
		//		Else, switch to that block
		//		
		//		Update Current_Block to that block

		//	IF finds "END" directive, terminate

		if (new_block)
		{	// if this is the first instance of a block
			new_block = false;	// reset boolean
			
			if (!line[0].isEmpty())
			{
				Blocks.add(new ProgramBlock(line[0]));
				Current_Block = Blocks.size() - 1;
			}
			else
			{
				System.out.println("ERROR: New block defined, but no name provided.");
				System.out.println("Terminating First Pass");
				return true;
			}
		}
		
		if (!line[0].isEmpty())
		{
			if (Local_Labels != null)
			{
				if (Local_Labels.Find(line[0]) == -1)
				{	// If not duplicate label, add to Local_Labels
					if (line[1].equals("EQU"))
						Local_Labels.Add_Next(line[0], Blocks.get(Current_Block).size(), Current_Block, true);
					else
						Local_Labels.Add_Next(line[0], Blocks.get(Current_Block).size(), Current_Block);
				}
				else	// Otherwise, duplicate symbol definitions are errors ;)
				{
					System.out.println("ERROR: Duplicate Symbolo Definition of " + line[0]);
				}
			}
			else
			{
				Local_Labels = new SymTable(line[0], Blocks.get(Current_Block).size(), Current_Block);
			}
		}

		if (!line[1].isEmpty())
		{	// Check for Assembler Directives XREF, XDEF, END
			switch (line[1])
			{
			case "XREF":
				// Make note of symbol needed from Global Labels TO Local Labels
				if (Global_Labels_XDEF == null)
				{
					Global_Labels_XDEF = new SymTable(line[2], 0, Current_Block);
				}
				else
				{
					if (Global_Labels_XDEF.Find(line[2]) == -1)
					{	// If symbol does not exist in the SymTab
						Global_Labels_XDEF.Add_Next(line[2], 0, Current_Block);
					}
					else
					{	// Otherwise, duplicate symbol definition
						error_state = true;
						System.out.println("Duplicate Global Symbol Definition of " + line[2]);
						System.out.println("Terminating First Pass...");
						return true;
					}
				}
				return false;

			case "XDEF":
				// Make note of symbol needed from Local Labels TO Global Labels
				
				if (Global_Labels_XDEF == null)
				{
					Global_Labels_XDEF = new SymTable(line[2], Blocks.get(Current_Block).size(), Current_Block);
				}
				else
				{
					if (Global_Labels_XDEF.Find(line[2]) == -1)
					{
						Global_Labels_XDEF.Add_Next(line[2], Blocks.get(Current_Block).size(), Current_Block);
					}
					else
					{
						error_state = true;
						System.out.println("Duplicate Global Symbol Definition of " + line[2]);
						System.out.println("Terminating First Pass...");
						return true;
					}
				}
				return false;

			case "USE":
				// Switch to block specified
				// If block not yet defined, create a new one
				
				if (line[2].isEmpty())	// if no label called as arg, this is a new block
				{
					new_block = true;
					break;
				}
				for (int i= 0; i < Blocks.size(); i++)
				{
					Current_Block = i;

					if (Blocks.get(i).Name().equals(line[2]))
					{
						break;
					}
				}

				if (Current_Block == Blocks.size())
				{	// error state
					System.out.println("ERROR: Undefined block '" + line[2] + "'");
					System.out.println("Terminating First Pass...");
					return true;
				}
				
				return false;
			}
		}
		
		ProgramBlock tempBlock = Blocks.get(Current_Block);
		if (tempBlock.Loop(line))
		{
			System.out.println("An error has occurred, terminating First Pass.");
			return true;
		}
		Blocks.set(Current_Block, tempBlock);

		return error_state;
	}
	
	public int Print(int offset)
	{
		try {
			FileWriter output = new FileWriter(code_output);
			offset = Print(offset, output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return offset;
	}
	
	public int Print(int offset, FileWriter output)
	{	// Prints to some file, returns new offset
		
		for (int i = 0; i < Blocks.size(); i++)
		{
			ProgramBlock temp = Blocks.get(i);

			// Adjust Local Labels
			Local_Labels.Adjust_Offset(offset, i);
			
			// Print Operations to file
			output = temp.Print(offset, output);
			offset += temp.size();
		}
		
		return offset;
	}
	
	public SymTable XDEF()
	{
		return Global_Labels_XDEF;		
	}
	
	public SymTable XREF()
	{
		return Global_Labels_XREF;
	}
	
	public void XREF(SymTable XREF)
	{
		Global_Labels_XREF = XREF;
	}
	
	@SuppressWarnings("resource")
	public void Print_Labels()
	{
		// Assumes all labels are already incremented by their respective offsets
		
		try {
			FileWriter output = new FileWriter(label_output);
			
			if (Local_Labels != null)
				output = Local_Labels.Print(output, 0);
			
			if (Global_Labels_XREF != null)
				output = Global_Labels_XREF.Print(output, 0);
			
			output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
