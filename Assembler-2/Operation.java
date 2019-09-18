import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Operation {
	
	private Hex Location;
	private int Size;
	private String OpCode;
	private String Argument;
	
	private Operation Next;
	
	public Operation(int Location, int Size, String OpCode, String Argument)
	{
		this.Location = new Hex(Location, 6);
		
		this.Size = Size;
		this.OpCode = OpCode;
		this.Argument = Argument;
		this.Next = null;
	}
	
	public Operation()
	{
		this.Location = new Hex(0, 6);
		this.Next = null;
	}
	
	public void set_Location(int Location)
	{
		this.Location.Add(Location);
	}
	
	public void set_OpCode(String OpCode)
	{
		this.OpCode = OpCode;	
	}
	
	public void set_Size(int Size)
	{
		this.Size = Size;
	}
	
	public void set_Argument(String Argument)
	{
		this.Argument = Argument;
	}
	
	public void Add_Next(Operation Next)
	{
		if (this.Next == null)
			this.Next = Next;
		else
			this.Next.Add_Next(Next);
	}
	
	public Operation Next()
	{
		return Next;
	}
	
	public FileWriter Print(String filename, int offset) throws IOException
	{
		if (Argument == null)
			Argument = "";
		
		try {
			FileWriter output = new FileWriter(filename);
			
			// Clear file of previous information
			output.flush();
			
			// Append with new information
			System.out.println(Location.code + "\t" + Size + "\t" + OpCode + "\t" + Argument);
			output.append(Location.code + "\t" + Size + "\t" + OpCode + "\t" + Argument + "\n");
			Next.Print(output, offset);
			
			return output;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public FileWriter Print(FileWriter output, int offset) throws IOException
	{
		if (Argument == null)
			Argument = "";
		
		Location.Add(offset);
		
		if (Size != 0)
		{
			System.out.println(Location.code + "\t" + Size + "\t" + OpCode + "\t" + Argument);
			output.append(Location.code + "\t" + Size + "\t" + OpCode + "\t" + Argument + "\n");
		}

		if (Next != null)
			return Next.Print(output, offset);
		else
			return output;
	}
}
