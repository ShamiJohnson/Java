
public class Directive {
	public String Code;
	public String Arg;
	public int Size;
	
	private int word_length = 3;
	private boolean store_data;
	private boolean store_word;
	private boolean prog_start;
	private boolean prog_term;
	private boolean stores_one;
	
	Directive(String Code)
	{
		this.Code = Code;
		Compare();
		
		Size = 0;
		
		Arg = null;
		
		if (store_data && store_word && stores_one && prog_start && prog_term)
		{	// No match found
			System.out.println("Invalid Assembler Directive: " + Code);
		}
	}
	
	public boolean is_valid()
	{
		if (store_data && store_word && stores_one && prog_start && prog_term)
			return false;
		else
			return true;
	}
	
	public void Add_Arg(String Arg)
	{
		this.Arg = Arg;
	}
	
	public int Evaluate_Size()
	{
		if (store_data)
			if (store_word)
			{
				if (stores_one)
					Size = Arg.length() * word_length;
				else
				{
					int arg_int = String_To_Int(Arg);
					Size = word_length * arg_int;
				}
			}
			else
			{
				if (stores_one)
					Size = Arg.length();
				else
				{
					int arg_int = String_To_Int(Arg);
					Size = word_length * arg_int;
				}
			}
		
		return Size;
	}
	
	private int String_To_Int(String Arg)
	{
		int result = 0;
		
		for (int i = 0; i < Arg.length(); i++)
		{
			result *= 10;
			result += (int)(Arg.charAt(i) - '0');
		}
		return result;
	}
	
	private void Compare()
	{	// Check this directive versus all known
		switch (this.Code.hashCode())
		{
		case 79219778:
			// START
			store_data = false;
			store_word = false;
			prog_start = true;
			prog_term = false;
			break;

		case 68795:
			// END
			store_data = false;
			store_word = false;
			prog_start = false;
			prog_term = true;
			break;

		case 2511810:
			// RESB
			store_data = true;
			store_word = false;
			stores_one = false;
			prog_start = false;
			prog_term = false;
			break;

		case 2511831:
			// RESW
			store_data = true;
			store_word = true;
			stores_one = false;
			prog_start = false;
			prog_term = false;
			break;

		case 68905:
			// EQU
			store_data = false;
			store_word = false;
			stores_one = false;
			prog_start = false;
			prog_term = false;
			break;

		case 2059251268:
			// EXTDEF
			store_data = false;
			store_word = false;
			stores_one = false;
			prog_start = false;
			prog_term = false;
			break;

		case 2059264722:
			// EXTREF
			store_data = false;
			store_word = false;
			stores_one = false;
			prog_start = false;
			prog_term = false;
			break;

		case 64417030:
			// CSECT
			store_data = false;
			store_word = false;
			stores_one = false;
			prog_start = false;
			prog_term = false;
			break;

		case 2054408:
			// BYTE
			store_data = true;
			store_word = false;
			stores_one = true;
			prog_start = false;
			prog_term = false;
			break;

		case 2670346:
			// WORD
			store_data = true;
			store_word = true;
			stores_one = true;
			prog_start = false;
			prog_term = false;
			break;

		case 2031313:
			// BASE
			store_data = false;
			store_word = false;
			prog_start = false;
			prog_term = false;
			break;

		case 73114540:
			// MACRO
			store_data = false;
			store_word = false;
			prog_start = false;
			prog_term = false;
			break;

		case 2362702:
			// MEND
			store_data = false;
			store_word = false;
			prog_start = false;
			prog_term = false;
			break;

		case 84327:
			// USE
			store_data = false;
			store_word = false;
			prog_start = false;
			prog_term = false;
			break;
			
		case 72768572:
			// LTORG
			store_data = false;
			store_word = false;
			prog_start = false;
			prog_term = false;
			break;
			
		default:
			store_data = true;
			store_word = true;
			stores_one = true;
			prog_start = true;
			prog_term = true;
		}
	}
}
