
import java.util.ArrayList;

public class FirstPass {

	public static boolean Run(String input_filename)
	{					
		ArrayList<ControlSection> Sections = new ArrayList<ControlSection>();
		Sections.add(new ControlSection(input_filename));
		
		int Current_Sect = 0;
		boolean error_state = false;
		boolean is_ended = false;
		
		String file_extension = new String(".txt");

		System.out.println("Assembling " + input_filename + file_extension);

		Reader myFile = new Reader(input_filename + file_extension);
		String[] line;

		Literal LitTab = null;	// Literals are GLOBAL, process them as such

		while ((line = myFile.ReadLine()) != null && !error_state && !is_ended)
		{
			//	Check for "CSECT" directive
			//		IF found, create new ControlSection
			//		SWITCH to the new section, old section abandoned until interm file generation
			
			//	IF finds "END" directive, terminate
			
			if (line.length <= 1)
				break;
			
			if (!line[1].isEmpty())
			{	// Check for Assembler Directives XREF, XDEF, END
				
				switch (line[1])
				{
				case "CSECT":
					// create new ControlSection
					// switch to that ControlSection
					if (line[2].isEmpty())
					{
						System.out.println("Error: Control Section Not Defined!");
						System.out.println("Terminating First Pass...");
						return true;	// error_state = true return value, 2nd pass will not be called
					}
					else
					Sections.add(new ControlSection(line[2]));
					break;
					
				case "END":
					// Set boolean to stop First Pass
					is_ended = true;
					break;
					
				}
			}
			
			if (line.length > 2)
			{
				if (!line[2].isEmpty())
				{	// Check Arguments for Literals
					// Literals are global

					if (line[2].indexOf('=') != -1)
					{	// If this is a literal, Make note in Global Literal Table
						if (LitTab != null)
							LitTab.Add(new Literal(line[2]));
						else
							LitTab = new Literal(line[2]);
					}
				}
			}

			// Only after sanitizing input do we update the ControlSection and its Blocks
			ControlSection tempSect = Sections.get(Current_Sect);
			if (tempSect.Loop(line))
			{
				System.out.println("An error has occurred, terminating First Pass.");
				return true;
			}
		}
		
		// Print the Control Sections
		// Also Updates all LOCAL Symbols
		int offset = 0;
		
		for (int i = 0; i < Sections.size(); i++)
		{
			ControlSection temp = Sections.get(i);
			offset += temp.Print(offset);
		}
		
		// Retrieves all XDEFed symbols
		ArrayList<SymTable> XDEF = new ArrayList<SymTable>(0);
		for (int i = 0; i < Sections.size(); i++)
		{
			XDEF.add(Sections.get(i).XDEF());
		}
		
		// Updates all XREFed symbols
		for (int i = 0; i < Sections.size(); i++)
		{	// Increment through all CSECTs
			
			SymTable temp_XREF = Sections.get(i).XREF();
			SymTable XREF = null;
			
			for (int j = 0; j < XDEF.size(); j++)
			{	// Pull all required labels from Global into their Local XREF
				
				for (; temp_XREF != null; temp_XREF = temp_XREF.Next())
				{	// Increment through all labels in the XREF
					int val;
					if ((val = XDEF.get(j).Find(temp_XREF.Name())) != -1)
					{
						
						if (XREF == null)
						{
							XREF = new SymTable(temp_XREF.Name(), val, 0);
						}
						else
						{
							if (XREF.Find(temp_XREF.Name()) == -1)
								XREF.Add_Next(temp_XREF.Name(), val, 0);
							else
							{
								System.out.println("ERROR: " + temp_XREF.Name() + "is defined in multiple Control Sections!");
								System.out.println("Terminating First Pass...");
								return true;
							}
						}
						
					}
				}				
			}
			
			ControlSection temp_Sect = Sections.get(i);
			temp_Sect.XREF(XREF);
			Sections.set(i, temp_Sect);
		}
		
		// Print all Control Section Symbols (Local and XREF)
		for (int i = 0; i < Sections.size(); i++)
		{
			Sections.get(i).Print_Labels();
		}
		
		// Print the Literals
		if (LitTab != null)
			LitTab.Print(offset);	// Places literals at the end of program memory
		else
			Literal.Print_Empty();	// In case no literals are present in the code
		
		// We're done here
		System.out.println("First Pass Complete");		
		return error_state;
	}
}
