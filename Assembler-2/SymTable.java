/*
* SHAWN NISAR
PURPOSE: 
	the purpose of this program is to read in the delimited strings and then split it. after splitting it campare to the symbol table and send the correct values to be printed in the right order.
*/

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class pass1 {
	public static void main(String[] args) {

		//subtitute this code with Nicks code 
		BufferedReader bufferreader = null;
		FileReader filereader = null;

		FileWriter filewriter = null;
		BufferedWriter bufferwriter = null;
		try
		{
			//subtitute this code with Nicks code 
			//Subbing in - Nick
			String inputfilename = "basic.txt";
			filereader = new FileReader(inputfilename);
			bufferreader = new BufferedReader(filereader);
			String line = ""; 
			while((line = bufferreader.readLine()) != null)
			{
				int commentDot = line.indexOf(".");
				if (commentDot != -1)
				{
    					line = line.substring(0, commentDot);
				}
				System.out.println("Dot at: " + commentDot);
				String[] add = line.split ("\\s+");
				for (String part : add)
				{
					System.out.println(part);
				}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}


			





//shawn code start.


			//imperative statement hash table
			//contains "mneumonic", "opcode"
			Hashtable<String, String> imperative = new Hashtable<String, String>();
			imperative.put("ADD", "18");
			imperative.put("ADDR", "90");
			imperative.put("COMPR", "A0");
			imperative.put("JLT", "38");

			//declarative hash table
			//contains "mneumonic", "opcode"
			Hashtable<String, String> declarative = new Hashtable<String, String>();
			declarative.put("LDS", "6C");
			declarative.put("LDT", "74");
			declarative.put("LDX", "04");
			declarative.put("LDA", "00");
			declarative.put("STA", "0C");

			//Assembler Directives hash table
			//contains "mneumonic", "opcode"
			Hashtable<String, String> asmDirectives = new Hashtable<String, String>();
			asmDirectives.put("START", "");
			asmDirectives.put("END", "");
			asmDirectives.put("RESW", "");


			//creating hash table data structure for type String, String
			Hashtable<String, String> symTable = new Hashtable<String, String>();

String currentLine;
int locPointer = 0; 
int symPointer = 0;

//reads file line by line in order with the help of buffered reader  (from Nick)
currentLine = bufferreader.readLine();

//using already delimitted code (from Ben)

while ((currentLine = bufferreader.readLine()) != null) {

				int incrementLoc = 0; //used to increment the value of location pointer 
				String typeOF = null; //String initialized to check the type of the statement

				int flag = 0;	// integer initialized to check if the address is being assign to symbol
				
				//currently splitting it with comma. depends on how ben split the line 
				String symbol = currentLine.split(",")[0];	//at the first word of the current line
				
				//using a for each loop. meaning: for each symbol in symTable which exists there
				for (Map.Entry exists : symTable.entrySet()) {	//check if the "symbol" "exists" in the symTable or not
					if (symbol.equals(exists.getKey())) {		//if it exists then:
						exists.setValue(locPointer);				//initialize the address to location pointer 
						flag = 1;								//Updates the value of flag from 0 to 1
					}
				}

				if (symbol.length() != 0 && flag == 0) {		//if the string is not null and the value of flag is 0 then: 
															//this string has to be a new string			
					symTable.put(symbol, String.valueOf(locPointer));
					symPointer++; //increments the value of symPointer
				}

				//repeating the same process for opcode

				int isItOpcode = 0;		//this will determine if the symbol is opcode OR not 
				
				symbol = currentLine.split(",")[1];			//updates the symbol value to the second word in line 
				
				for (Map.Entry symbol : imperative.entrySet()) {
					if (symbol.equals(symbol.getKey())) {
						bufferwriter.write("\t" + symbol.getValue() + "\t");		//if there is a match then update values 
						typeOF = "imperative";
						isItOpcode = 1;
					}
				}

				//repeating the same process for Assembler directives 
				for (Map.Entry symbol : asmDirectives.entrySet()) {
					if (symbol.equals(symbol.getKey())) {
						bufferwriter.write("\t" + symbol.getValue() + "\t");		//if there is a match then update values 
						typeOF = "asmDirectives";
						isItOpcode = 1;
					}
				}


				//repeating the same process for declarative statement 
				for (Map.Entry symbol : declarative.entrySet()) {
					if (symbol.equals(symbol.getKey())) {
						bufferwriter.write("\t" + symbol.getValue() + "\t");		//if there is a match then update values 
						typeOF = "declarative";
						isItOpcode = 1;
					}
				}
			
				
				if (sCurrentLine.split(",").length > 2) {		//if there are more than 2 words 
					symbol = sCurrentLine.split(",")[2];				//update symbols value with that word 
																	
																	//should be an operand 
				

				//it has to be a symbol entry, a register entrty or a declaration entry 
					if (symbol.equals("ALPHA")) {
						bufferwriter.write("1");
						isItOpcode = 1;
					} else if (symbol.equals("BETA")) {
						bufferwriter.write("2");
						isItOpcode = 1;
					} else if (symbol.equals("GAMMA")) {
						bufferwriter.write("3");
						isItOpcode = 1;
					} else if (type == "declarative") {
						bufferwriter.write(symbol);
					} else {
						symTable.put(symbol, "");				//It must be a forward reference symbol
					}
				}
				
					if (currentLine.split(",").length > 3) {		//if there are more than 3 words 
					
					symbol = currentLine.split(",")[3];			//update symbol value 
																//2nd operand
																
					
						symTable.put(symbol, "");			
						bufferwriter.write("\t" + symPointer + "\t");		
						symPointer++;
						
					
				}

				bufferwriter.write("\n");		//goes to next line 

//increments the location counter. previously declared it to be 0 so it will stay true 
				if (incrementLoc == 0)
					locPointer++; 
}

//shawn code ENDS.








//subtitute this code with Nicks code 
//Nick here. Subbing it in.
String OUTPUTFILENAME = "basicOpCode.txt";
			filewriter = new FileWriter(OUTPUTFILENAME);
			bufferwriter = new BufferedWriter(filewriter);
			String line = ""; 
			while((line = bufferwriter.readLine()) != null)
			{
				int commentDot = line.indexOf(".");
				if (commentDot != -1)
				{
    					line = line.substring(0, commentDot);
				}
				System.out.println("Dot at: " + commentDot);
				String[] add = line.split ("\\s+");
				for (String part : add)
				{
					System.out.println(part);
				}
			}
		





		

	}

}
