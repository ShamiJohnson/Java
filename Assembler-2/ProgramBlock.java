import java.io.FileWriter;
import java.io.IOException;


public class ProgramBlock {
	private String Block_Name;
	
	private Operation OpTab;
	
	private String input_file;
	private String output_filename;
	
	private int Location_Counter;
	
	public ProgramBlock(String input_filename)
	{
		this.Block_Name = new String("");
		this.input_file = input_filename.substring(0,input_filename.indexOf("."));
		
		this.OpTab = null;
		
		this.output_filename = new String("");
		this.output_filename = input_filename + "_code.txt";
	}
	
	public int size()
	{
		return Location_Counter;
	}
	
	public void Name(String new_name)
	{
		this.Block_Name = new_name;
	}
	
	public String Name()
	{
		return Block_Name;
	}
	
	public boolean Loop(String[] line)
	{
		// Increment through line
		// Follows Pattern:
		//		Label	Mnemonic	Argument	Comment
		//		Reader removes comments	

		boolean error_state = false;
		
		// Temporary storage of data structures
		Operation temp_op = null;
		Mnemonic temp_mne = null;
		Directive temp_dir = null;
		
		boolean is_assembler_directive = false;
		
		for (int i = 1, num_found = 0; i < line.length; i++)
		{	// Increment through line tab delimited
			// Look for non-null string
			
			if (!line[i].isEmpty())
			{
				num_found++;

				if (num_found == 1)
				{	// Mnemonic found
					temp_mne = Convert_Mnemonic(line[i]);
					if (temp_mne != null)
					{
						temp_op = new Operation();

						temp_op.set_OpCode(temp_mne.OpCode);
						temp_op.set_Size(temp_mne.Size);
						temp_op.set_Location(Location_Counter);

						Location_Counter += temp_mne.Size;
					}
					else
					{	// Assembler Directive?
						temp_dir = new Directive(line[i]);
						if (temp_dir.is_valid())
						{
							temp_op = new Operation();

							temp_op.set_OpCode("");
							temp_op.set_Size(0);
							temp_op.set_Location(Location_Counter);

							is_assembler_directive = true;
						}
						else
						{
							System.out.println("ERROR: Unknown Assembler Directive '" + line[i] + "'");
							return true;
						}
					}
				}
				else if(num_found == 2)
				{	// Argument found
					if (is_assembler_directive)
					{
						temp_dir.Add_Arg(line[i]);
						temp_dir.Evaluate_Size();
						temp_op.set_Size(temp_dir.Size);
						
						Location_Counter += temp_dir.Size;
					}
					else
					{		
						temp_op.set_Argument(line[i]);
					}
				}
				else
					error_state = true;
			}
		}
		
		if (OpTab == null)
			OpTab = temp_op;
		else
			OpTab.Add_Next(temp_op);
		
		return error_state;
	}
	
	
	public FileWriter Print(int offset, FileWriter output)
	{
		if (output == null)
		{
			try {
				return OpTab.Print(output_filename, offset);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		}
		else
		{
			try {
				return OpTab.Print(output, offset);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
	
	public static Mnemonic Convert_Mnemonic(String mnemonic)
	{
		switch (mnemonic.hashCode())
		{
		case 64641:
			// ADD
			return new Mnemonic("000110", 3);

		case 65974:
			// +ADD
			return new Mnemonic("000110", 4);

		case 2003941:
			// ADDF
			return new Mnemonic("010110", 3);

		case 2005274:
			// +ADDF
			return new Mnemonic("010110", 4);

		case 2003953:
			// ADDR
			return new Mnemonic("100100", 2);

		case 64951:
			// AND
			return new Mnemonic("010000", 3);

		case 66284:
			// +AND
			return new Mnemonic("010000", 4);

		case 64208429:
			// CLEAR
			return new Mnemonic("101101", 2);

		case 2074383:
			// COMP
			return new Mnemonic("001010", 3);

		case 2075716:
			// +COMP
			return new Mnemonic("001010", 4);

		case 64305943:
			// COMPF
			return new Mnemonic("100010", 3);

		case 64307276:
			// +COMPF
			return new Mnemonic("100010", 4);

		case 64305955:
			// COMPR
			return new Mnemonic("101000", 2);

		case 67697:
			// DIV
			return new Mnemonic("001001", 3);

		case 69030:
			// +DIV
			return new Mnemonic("001001", 4);

		case 2098677:
			// DIVF
			return new Mnemonic("011001", 3);

		case 2100010:
			// +DIVF
			return new Mnemonic("011001", 4);

		case 2098689:
			// DIVR
			return new Mnemonic("100111", 3);

		case 2100022:
			// +DIVR
			return new Mnemonic("100111", 4);

		case 69621:
			// FIX
			return new Mnemonic("110001", 2);

		case 66988604:
			// FLOAT
			return new Mnemonic("110000", 1);

		case 71534:
			// HIO
			return new Mnemonic("111101", 1);

		case 74:
			// J
			return new Mnemonic("001111", 1);

		case 73334:
			// JEQ
			return new Mnemonic("001100", 1);

		case 73399:
			// JGT
			return new Mnemonic("001101", 3);

		case 74732:
			// +JGT
			return new Mnemonic("001101", 4);

		case 73554:
			// JLT
			return new Mnemonic("001110", 3);

		case 74887:
			// +JLT
			return new Mnemonic("001110", 4);

		case 2286998:
			// JSUB
			return new Mnemonic("001010", 3);

		case 41998401:
			// +JSUB
			return new Mnemonic("001010", 4);

		case 75209:
			// LDA
			return new Mnemonic("000000", 3);

		case 76542:
			// +LDA
			return new Mnemonic("000000", 4);

		case 75210:
			// LDB
			return new Mnemonic("011010", 3);

		case 76543:
			// +LDB
			return new Mnemonic("011010", 4);

		case 72279920:
			// LDCCH
			return new Mnemonic("010100", 3);

		case 72281253:
			// +LDCCH
			return new Mnemonic("010100", 4);

		case 75214:
			// LDF
			return new Mnemonic("011100", 3);

		case 76547:
			// +LDF
			return new Mnemonic("011100", 4);

		case 75220:
			// LDL
			return new Mnemonic("000010", 3);

		case 76553:
			// +LDL
			return new Mnemonic("000010", 4);

		case 75227:
			// LDS
			return new Mnemonic("011011", 3);

		case 76560:
			// +LDS
			return new Mnemonic("011011", 4);

		case 75228:
			// LDT
			return new Mnemonic("011101", 3);

		case 76561:
			// +LDT
			return new Mnemonic("011101", 4);

		case 75232:
			// LDX
			return new Mnemonic("000001", 3);

		case 76565:
			// +LDX
			return new Mnemonic("000001", 4);

		case 75599:
			// LPS
			return new Mnemonic("110100", 3);

		case 76932:
			// +LPS
			return new Mnemonic("110100", 4);

		case 76708:
			// MUL
			return new Mnemonic("001000", 3);

		case 78041:
			// +MUL
			return new Mnemonic("001000", 4);

		case 2378018:
			// MULF
			return new Mnemonic("011000", 3);

		case 2379351:
			// +MULF
			return new Mnemonic("011000", 4);

		case 2378030:
			// MULR
			return new Mnemonic("100110", 2);

		case 2402236:
			// NORM
			return new Mnemonic("110010", 1);

		case 2531:
			// OR
			return new Mnemonic("010001", 3);

		case 3864:
			// +OR
			return new Mnemonic("010001", 4);

		case 2610:
			// RD
			return new Mnemonic("110110", 3);

		case 3943:
			// +RD
			return new Mnemonic("110110", 4);

		case 81268:
			// RMO
			return new Mnemonic("101011", 2);

		case 2525326:
			// RSUB
			return new Mnemonic("010011", 3);

		case 2526659:
			// +RSUB
			return new Mnemonic("010011", 4);

		case -1850009558:
			// SHIFTL
			return new Mnemonic("101001", 2);

		case -1850009552:
			// SHIFTR
			return new Mnemonic("101010", 2);

		case 82105:
			// SIO
			return new Mnemonic("111100", 1);

		case 82411:
			// SSK
			return new Mnemonic("111011", 3);

		case 83744:
			// +SSK
			return new Mnemonic("111011", 4);

		case 82432:
			// STA
			return new Mnemonic("000011", 3);

		case 83765:
			// +STA
			return new Mnemonic("000011", 4);

		case 82433:
			// STB
			return new Mnemonic("011110", 3);

		case 83766:
			// +STB
			return new Mnemonic("011110", 4);

		case 2555526:
			// STCH
			return new Mnemonic("010101", 3);

		case 2556859:
			// +STCH
			return new Mnemonic("010101", 4);

		case 82437:
			// STF
			return new Mnemonic("100000", 3);

		case 83770:
			// +STF
			return new Mnemonic("100000", 4);

		case 82440:
			// STI
			return new Mnemonic("110101", 3);

		case 83773:
			// +STI
			return new Mnemonic("110101", 4);

		case 82443:
			// STL
			return new Mnemonic("000101", 3);

		case 83776:
			// +STL
			return new Mnemonic("000101", 4);

		case 82450:
			// STS
			return new Mnemonic("011111", 3);

		case 83783:
			// +STS
			return new Mnemonic("011111", 4);

		case 2556037:
			// STSW
			return new Mnemonic("111010", 3);

		case 2557370:
			// +STSW
			return new Mnemonic("111010", 4);

		case 82451:
			// STT
			return new Mnemonic("100001", 3);

		case 83784:
			// +STT
			return new Mnemonic("100001", 4);

		case 82455:
			// STX
			return new Mnemonic("000100", 3);

		case 83788:
			// +STX
			return new Mnemonic("000100", 4);

		case 82464:
			// SUB
			return new Mnemonic("000111", 3);

		case 83797:
			// +SUB
			return new Mnemonic("000111", 4);

		case 2556454:
			// SUBF
			return new Mnemonic("011111", 3);

		case 2557787:
			// +SUBF
			return new Mnemonic("011111", 4);

		case 2556466:
			// SUBR
			return new Mnemonic("100101", 2);

		case 82496:
			// SVC
			return new Mnemonic("101100", 2);

		case 2672:
			// TD
			return new Mnemonic("111000", 3);

		case 4005:
			// +TD
			return new Mnemonic("111000", 4);

		case 83066:
			// TIO
			return new Mnemonic("111110", 1);

		case 83075:
			// TIX
			return new Mnemonic("001011", 3);

		case 84408:
			// +TIX
			return new Mnemonic("001011", 4);

		case 2575407:
			// TIXR
			return new Mnemonic("101110", 2);

		case 2765:
			// WD
			return new Mnemonic("110111", 3);

		case 4098:
			// +WD
			return new Mnemonic("110111", 4);

		default:
			return null;
		}
	}

}
