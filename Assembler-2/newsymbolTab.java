import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;


public class newsymbolTab {
try {
	
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
				
				for (Map.Entry exists : imperative.entrySet()) {
					if (symbol.equals(exists.getKey())) {
						bufferwriter.write("\t" + exists.getValue() + "\t");		//if there is a match then update values 
						typeOF = "imperative";
						isItOpcode = 1;
					}
				}

				//repeating the same process for Assembler directives 
				for (Map.Entry exists : asmDirectives.entrySet()) {
					if (symbol.equals(exists.getKey())) {
						bufferwriter.write("\t" + exists.getValue() + "\t");		//if there is a match then update values 
						typeOF = "asmDirectives";
						isItOpcode = 1;
					}
				}


				//repeating the same process for declarative statement 
				for (Map.Entry exists : declarative.entrySet()) {
					if (symbol.equals(exists.getKey())) {
						bufferwriter.write("\t" + exists.getValue() + "\t");		//if there is a match then update values 
						typeOF = "declarative";
						isItOpcode = 1;
					}
				}
			
				
				if (currentLine.split(",").length > 2) {		//if there are more than 2 words 
					symbol = currentLine.split(",")[2];				//update symbols value with that word 
																	
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
					} else if (typeOF == "declarative") {
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




String symTabFile = "SYMTAB.txt";
			FileWriter filewriter1 = new FileWriter(symTabFile);
			BufferedWriter bufferwriter1 = new BufferedWriter(filewriter1);
			for (Map.Entry symbol : symtab.entrySet()) {
				bw1.write(symbol.getKey() + "\t" + symbol.getValue()+"\n");				
				System.out.println(symbol.getKey() + " " + symbol.getValue());
			}

			
bufferwriter1.close();

} catch (IOException e) {
			e.printStackTrace();
		}


}
















