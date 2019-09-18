
public class SecondPass {
	public static void Run(String output_filename)
	{
		/*	TODO:	All this
		 * 	STEPS:
		 * 		1.	Reassemble Literal Table
		 * 		2.	Reassemble Label Table
		 * 			a)	Assume Labels.txt is all global labels
		 * 			b)	To accommodate XREF	mark all labels with a boolean of
		 * 				whether the file can see this label
		 * 				-	Non-existent labels will generate an error and end the program
		 * 		3.	Parse filenames.txt for all processed files
		 * 			a)	Assume all null OpCodes with Args are accessing labels as XREF for now
		 * 		4.	Assemble these intermediate files into a program file
		 *		5.	Parse Literal Table a second time to implement Literals to the program code
		*/
		
		
	}
}
