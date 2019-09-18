import java.io.FileWriter;
import java.io.IOException;

public class Literal {
	
	private Literal Next;
	private String Value;	
	
	public Literal(String Arg)
	{
		Next = null;
		
		String[] temp = Arg.split("'");		
		
		switch (temp[0].charAt(1))
		{
		case 'A':	// Address value, treated same as Hex
		case 'X':	// Hex value, no translation required, length may need to be adjusted
			if (temp[1].length() > 2)
				Value = temp[1].substring(0, 2);
			else if (temp[1].length() < 2)
				Value = "0" + temp[1];
			else
				Value = temp[1];
		
			break;
			
		case 'C':	// Character value, translate value to hex
			Value = char_to_hex(temp[1]);
			break;
			
		case 'B':	// Binary value
			Value = bin_to_hex(temp[1]);
			break;
			
		default:
			Value = null;
		}
	}
	
	private String bin_to_hex(String input)
	{
		String result = new String("");
		String temp = new String("");
		
		for (; input.length() > 4; input = input.substring(0, input.length() - 4))
			temp += HexConverter.Convert(input.substring(input.length() - 4, input.length()));
		
		temp += HexConverter.Convert(input.substring(0, input.length()));
		
		for (int i = temp.length() - 1; i >= 0; i--)
			result += temp.charAt(i);
		
		return result;
	}
	
	private String char_to_hex(String input)
	{
		String output = new String("");
		
		if (input.length() == 1)
		{
			output = int_to_hex((int)input.charAt(0));
		}	
		else
		{
			if (input.equals("NUL") || input.equals("EOF"))
				output = "00";	// NULL Character
			if (input.equals("SOH"))
				output = "01";	// Start of Heading
			if (input.equals("STX"))
				output = "02";
			if (input.equals("ETX"))
				output = "03";
			if (input.equals("EOT"))
				output = "04";	
			if (input.equals("ENQ"))
				output = "05";
			if (input.equals("ACK"))
				output = "06";
			if (input.equals("BEL"))
				output = "07";
			if (input.equals("BS"))
				output = "08";
			if (input.equals("\t") || input.equals("TAB"))
				output = "09";	// Tab Character
			if (input.equals("\n") || input.equals("NL") || input.equals("LF"))
				output = "0A";	// Newline Character
			if (input.equals("VT"))
				output = "0B";
			if (input.equals("FF"))
				output = "0C";	//
			if (input.equals("CR"))
				output = "0D";	//
			if (input.equals("SO"))
				output = "0E";	//
			if (input.equals("SI"))
				output = "0F";
			if (input.equals("DLE"))
				output = "10";
			if (input.equals("DC1"))
				output = "11";
			if (input.equals("DC2"))
				output = "12";
			if (input.equals("DC3"))
				output = "13";
			if (input.equals("DC4"))
				output = "14";
			if (input.equals("NAK"))
				output = "15";
			if (input.equals("SYN"))
				output = "16";
			if (input.equals("ETB"))
				output = "17";
			if (input.equals("CAN"))
				output = "18";
			if (input.equals("EM"))
				output = "19";
			if (input.equals("SUB"))
				output = "1A";
			if (input.equals("ESC"))
				output = "1B";
			if (input.equals("FS"))
				output = "1C";
			if (input.equals("GS"))
				output = "1D";
			if (input.equals("RS"))
				output = "1E";
			if (input.equals("US"))
				output = "1F";
			if (input.equals("SPACE"))
				output = "20";
		}
		
		return output;
	}
	
	private String int_to_hex(int input)
	{
		return ((new Hex(input, 2)).code);
	}
	
	public void Add(Literal lit)
	{
		if (lit.Value == this.Value)
			return;
		
		if (Next != null)
			Next.Add(lit);
		else
			Next = lit;
	}
	
	public String Value()
	{
		return Value;
	}
	
	public void Print(int Location)
	{
		// Convert location to memory address
		
		System.out.println("Literals: ");
		
		Hex LOCCTR = new Hex(Location, 6);
		
		try {
			FileWriter output = new FileWriter("LitTab.txt");
			
			output.flush();
			
			Print(output, LOCCTR);
			
			output.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void Print(FileWriter output, Hex Location) throws IOException
	{
		if (!Value.isEmpty())
		{
			output.append(Location.code + "\t" + Value + "\n");
			System.out.println(Location.code + "\t" + Value + "\n");
			Location.Add(1);
		}
		
		if (Next != null)
			Next.Print(output, Location);
	}
	
	public static void Print_Empty()
	{
		try {
			FileWriter output = new FileWriter("LitTab.txt");
			output.flush();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
