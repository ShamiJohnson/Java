/*
* SHAWN NISAR
PURPOSE: 
	the purpose of this program is to read in the delimited strings and then split it. after splitting it campare to the symbol table and send the correct values to be printed in the right order.
*/

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;  

public class PassOne {
	public static void main(String[] args) {

		//subtitute this code with Nicks code 
		BufferedReader bufferreader = null;
		FileReader filereader = null;

		FileWriter filewriter = null;
		BufferedWriter bufferwriter = null;

		try {

			//subtitute this code with Nicks code 
			String inputfilename = "basic.txt";
			filereader = new FileReader(inputfilename);
			bufferreader = new BufferedReader(filereader);

			
//contains the intermediate code 
String OUTPUTFILENAME = "basicOpCode.txt";
			filewriter = new FileWriter(OUTPUTFILENAME);
			bufferwriter = new BufferedWriter(filewriter);


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
			asmDirectives.put("START", "01");
			asmDirectives.put("END", "02");
			asmDirectives.put("RESW", "");
			asmDirectives.put("EQU", "04");
			asmDirectives.put("LTORG", "05");
			


			//creating hash table data structure for type String, String
			Hashtable<String, String> symTable = new Hashtable<String, String>();
			Hashtable<String, String> litTable = new Hashtable<String, String>();
			ArrayList<Integer> poolTable = new ArrayList<Integer>();




String currentLine;
int locPointer = 0; 
int symPointer = 1;
int literalPointer = 1;
int poolPointer = 1;
String symbol;
String symbolLable;	


//reads file line by line in order with the help of buffered reader  (from Nick)
currentLine = bufferreader.readLine();

//using already delimitted code (from Nick)





String string1 = currentLine.split(" ")[1];
if (string1.equals("START")) {
	String string2 = currentLine.split(" ")[2];
	symbol = currentLine.split(" |\\,")[0];
	bufferwriter.write("0"+"\t"+symbol+"\t"+string1+"\t"+string2+"\n");
	locPointer = Integer.parseInt(string2);
}

while ((currentLine = bufferreader.readLine()) != null) {

				int incrementLoc = 0; //used to increment the value of location pointer 
				String typeOF = null; //String initialized to check the type of the statement

				int flag = 0;	// integer initialized to check if the address is being assign to symbol
				
				//currently splitting it with comma. depends on how ben split the line 
				symbol = currentLine.split(" |\\,")[0];	//at the first word of the current line
				
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


			



				
				symbol = currentLine.split(" |\\,")[1];			//updates the symbol value to the second word in line 
				
				for (Map.Entry exists : imperative.entrySet()) {
					if (symbol.equals(exists.getKey())) {
						symbolLable = currentLine.split(" |\\,")[0];	
						bufferwriter.write(locPointer+"\t"+symbolLable+"\t"+symbol+"\t");//if there is a match then update values 
						typeOF = "imperative";
						isItOpcode = 1;
					}
				}




				//repeating the same process for Assembler directives 
				for (Map.Entry exists : asmDirectives.entrySet()) {
					if (symbol.equals(exists.getKey())) {
					symbolLable = currentLine.split(" |\\,")[0];	
						bufferwriter.write(locPointer+"\t"+symbolLable+"\t"+symbol + "\t");		//if there is a match then update values 
						typeOF = "asmDirectives";
						isItOpcode = 1;
					}
				}





				//repeating the same process for declarative statement 
				for (Map.Entry exists : declarative.entrySet()) {
					if (symbol.equals(exists.getKey())) {
						symbolLable = currentLine.split(" |\\,")[0];	
						bufferwriter.write(locPointer+"\t"+symbolLable+"\t"+symbol + "\t");		//if there is a match then update values 
						typeOF = "declarative";
						isItOpcode = 1;
					}
				}




				if (symbol.equals("LTORG")) {
					poolTable.add(poolPointer);
					for (Map.Entry exists : litTable.entrySet()) {
						if (exists.getValue() == "") {				//if address is not assigned to the literal
							exists.setValue(locPointer);
							locPointer++;
							poolPointer++;
							incrementLoc = 1;
							isItOpcode = 1;
						}
					}
				}





				if (symbol.equals("END")) {
					poolTable.add(poolPointer);
					for (Map.Entry exists : litTable.entrySet()){
						if (exists.getValue() == ""){
							exists.setValue(locPointer);
							locPointer++;
							incrementLoc = 1;
						}
					}
				}




				if(symbol.equals("EQU")){
					symTable.put("equ", String.valueOf(locPointer));
				}


				
				if (currentLine.split(" |\\,").length > 2) {		//if there are more than 2 words 
					symbol = currentLine.split(" |\\,")[2];				//update symbols value with that word 
																	
																	//should be an operand 

				//it has to be a symbol entry, a register entrty or a declaration entry 
					if (symbol.equals("ALPHA")) {
						bufferwriter.write(symbol);
						isItOpcode = 1;
					} else if (symbol.equals("BETA")) {
						bufferwriter.write(symbol);
						isItOpcode = 1;
					} else if (symbol.equals("GAMMA")) {
						bufferwriter.write(symbol);
						isItOpcode = 1;
					} else if (typeOF == "declarative") {
						bufferwriter.write(""+symbol);
					} else if(typeOF=="imperative"){
							bufferwriter.write(""+symbol);
					}
					else if (typeOF == "asmDirectives"){
							bufferwriter.write(""+symbol);
					}
					else{
						symTable.put(symbol, "");				//It must be a forward reference symbol
					}
				}
				
					if (currentLine.split(" |\\,").length > 3) {		//if there are more than 3 words 
					
					symbol = currentLine.split(" |\\,")[3];			//update symbol value 
																//2nd operand

					if (symbol.contains("=")) {
						litTable.put(symbol, "");
						isItOpcode = 1;
						literalPointer++;
					}else if (typeOF == "declarative") {
						bufferwriter.write(","+symbol);
					} else if(typeOF=="imperative"){
							bufferwriter.write(","+symbol);
					}
					else if (typeOF == "asmDirectives"){
							bufferwriter.write(""+symbol);
					}
					 else {
						symTable.put(symbol, "");			//what if the current symbol is already present in the symbol table?	
						symPointer++;
					}

				}

				bufferwriter.write("\n");		//goes to next line 

//increments the location counter. previously declared it to be 0 so it will stay true 
				if (incrementLoc == 0)
					locPointer++; 
}

String symTabFile = "SYMTAB.txt";
			FileWriter filewriter1 = new FileWriter(symTabFile);
			BufferedWriter bufferwriter1 = new BufferedWriter(filewriter1);
			//basically prints the result
			for (Map.Entry exists : symTable.entrySet()) {
				bufferwriter1.write(exists.getKey() + "\t" + exists.getValue()+"\n");				
			}

String literalTable = "literalTable.txt";
			FileWriter filewriter2 = new FileWriter(literalTable);
			BufferedWriter bufferWritter2 = new BufferedWriter(filewriter2);
			//basically prints the result
			for (Map.Entry exists : litTable.entrySet()) {
				bufferWritter2.write(exists.getKey() + "\t" + exists.getValue()+"\n");
			}

			String pooltableOutput = "POOLTAB.txt";
			FileWriter filewriter3 = new FileWriter(pooltableOutput);
			BufferedWriter bufferwriter3 = new BufferedWriter(filewriter3);
			for (Integer item : poolTable) {  
				bufferwriter3.write(item+"\n");
			}

			bufferwriter.close();
			bufferwriter1.close();
			bufferWritter2.close();
			bufferwriter3.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		catch(IndexOutOfBoundsException arraylistcheck){
     		arraylistcheck.printStackTrace();
		}

	}

}









