import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;  

public class PassTwo {
	public static void main(String[] args) {
 
		BufferedReader bufferreader = null;
		FileReader filereader = null;
		FileWriter filewriter = null;
		BufferedWriter bufferwriter = null;

		BufferedReader label_Bufferreader = null;
		FileReader label_filereader = null;

		FileReader firstLineOutput_filereader = null;
		BufferedReader firstLineOutput_bufferreader = null;

		try {
			String inputfilename = "basic_code.txt";
			filereader = new FileReader(inputfilename);
			bufferreader = new BufferedReader(filereader);

//////Label Reader/////////////////////////////////////////////////////
			String label_inputfilename = "Labels.txt";
			label_filereader = new FileReader(label_inputfilename);
			label_Bufferreader = new BufferedReader(label_filereader);
			String labelLine;

			/// FIRST LINE////
			String first_inputfilename = "basic_code.txt";
			firstLineOutput_filereader = new FileReader(first_inputfilename);
			firstLineOutput_bufferreader = new BufferedReader(firstLineOutput_filereader);

//contains the FINAL Code
String OUTPUTFILENAME = "basicOpCode.txt";
filewriter = new FileWriter(OUTPUTFILENAME);
bufferwriter = new BufferedWriter(filewriter);


/////////////////////////////FIRST LINE BEGINS/////////////////////////
////////////////////use this code ONLY for the first line///////////////////////////////////
firstLineOutput_bufferreader = new BufferedReader(firstLineOutput_filereader);
String lastSize;
String lastLocation;
int lastLocationHEX =0;
int intlastSize = 0;
String firstLineOutput;
firstLineOutput = firstLineOutput_bufferreader.readLine();
String string1 = firstLineOutput.split("\\s+")[0];
String string2 = firstLineOutput.split("\\s+")[1];
firstLineOutput = firstLineOutput_bufferreader.readLine();
while ((firstLineOutput = firstLineOutput_bufferreader.readLine()) != null) {
lastLocation = firstLineOutput.split("\\s+")[0];
lastSize  = firstLineOutput.split("\\s+")[1]; 
intlastSize = Integer.parseInt(lastSize); 
    lastLocationHEX = Integer.parseInt(lastLocation, 16);
}
int sum = lastLocationHEX +intlastSize;
String sumHex = Integer.toHexString(sum);
String firstLine = ("H"+string2+" "+" "+"00"+string1+"00"+sumHex+"\n");
firstLine=firstLine.toUpperCase(Locale.ENGLISH);///////turns everything to uppercase. 
bufferwriter.write(firstLine);// This writes the first line. 
System.out.println(firstLine);
/////////////////////////////FIRST LINE ENDS/////////////////////////

    



String currentLine;
//Nick's added variables
char conHex;
HexConverter hexCon = new HexConverter();



//reads file line by line in order with the help of buffered reader
currentLine = bufferreader.readLine();


/// contains labels from intermediate file 
//Key=Value
Hashtable<String, String> labelTAB = new Hashtable<String, String>();
while ((labelLine = label_Bufferreader.readLine()) != null){			
		String labelName = labelLine.split("\\s+")[0];
		String labelLoc = labelLine.split("\\s+")[1];
		labelTAB.put(labelName, labelLoc);
//System.out.println(labelName+labelLoc);
	}







while ((currentLine = bufferreader.readLine()) != null) {
	
	//System.out.println(currentLine);
	//Retrieves the third piece of the line holding nixbpe bits
	String bits = currentLine.split("\\s+")[2];
	//If line doesn't have these values listed, skip past them.
	if(bits.equals("null"))
	{
		continue;
	}
	//Me testing with the converter lines 
	String conLine = bits.substring(0, 4);
	//System.out.println("conLine: "+ conLine);
	conHex = hexCon.hexConvert(conLine);
	
	String extra = bits.substring(4, 6);
	//System.out.println("extra: "+ extra);


String n ="0";
String i ="0";
String x ="0";
String b ="0";
String p ="0";
String e ="0";


String format = currentLine.split("\\s+")[1];
String val="";
int label_LocationINT =0;
int currentINT =0;



if (format.matches("1|2|3")){


	String operand = currentLine.split("\\s+")[3];

	if(operand.contains("#")){
		n="0";
		i="1";
	}
	if(operand.contains("X")){
		x="1";
	}





	String labelHere = currentLine.split("\\s+")[3];
	//System.out.println(labelHere);

	if (labelHere.contains(",")){

/*
	if (labelTAB.containsKey("BASIC")){
		System.out.println("YESSS");
	}
*/

		String labelNameCOMMA = labelHere.split(",")[0];
		//System.out.println(labelNameCOMMA);
		String labelNameCOMMA2 = labelHere.split(",")[1];
		//System.out.println(labelNameCOMMA2);


		
				for (Map.Entry exists : labelTAB.entrySet()) {	//check if the "symbol" "exists" in the symTable or not
					if (labelNameCOMMA.equals(exists.getKey())) {		//if it exists then:
						 val = (String) exists.getValue();				//initialize the address to location pointer 
						//System.out.println(exists.getKey()+": "+exists.getValue());
						label_LocationINT = Integer.parseInt(val, 16);
							
					}
					else if(labelNameCOMMA2.equals(exists.getKey())){

					}				
				}

String labelPLACE = currentLine.split("\\s+")[0];


	}
	else if (labelTAB.containsKey(labelHere)){
		for (Map.Entry exists : labelTAB.entrySet()) {	//check if the "symbol" "exists" in the symTable or not
					if (labelHere.equals(exists.getKey())) {		//if it exists then:
						 val = (String) exists.getValue();				//initialize the address to location pointer 
						//System.out.println(exists.getKey()+": "+exists.getValue());
						label_LocationINT = Integer.parseInt(val, 16);
							
					}
				}

	}


String current = currentLine.split("\\s+")[0];
currentINT = Integer.parseInt(current, 16);

int disp = currentINT-label_LocationINT;


if (disp>= -2048 && disp <= 2047 ){
	p="1";

	//System.out.println(disp);

}
else {
	b="1";
	//System.out.println("nope");
}


//first completed hex already
//conHex
//System.out.println(conHex);

//last 2 bits
String secondBit= extra +n +i; //add ni to it 01 values
//System.out.println(secondBit);
char secondHex = hexCon.hexConvert(secondBit);
//System.out.println(secondHex);


String thirdBit = x+b+p+e; //01 values
char thirdHex = hexCon.hexConvert(thirdBit);
//System.out.println(thirdHex);


//  disp is Hex now 
String dispHex = Integer.toHexString(disp);
dispHex=dispHex.toUpperCase(Locale.ENGLISH);//turns everything to uppercase.
//System.out.println(dispHex);

String opcode = conHex +""+ secondHex +""+ thirdHex +""+dispHex;

System.out.println(opcode);

String address = currentLine.split("\\s+")[0];
String textRec = "T" + address + opcode.length() + opcode;
bufferwriter.write(textRec);


	
}//End if format = 1|2|3
else if(format.matches("4"))
{
	e = "1";
	String operand = currentLine.split("\\s+")[3];
	if(operand.contains("#")){
		n="0";
		i="1";
	}

	if(operand.contains("X")){
		x="1";
	}

	String labelHere = currentLine.split("\\s+")[3];




	if (labelHere.contains(",")){




		String labelNameCOMMA = labelHere.split(",")[0];

		String labelNameCOMMA2 = labelHere.split(",")[1];




		

				for (Map.Entry exists : labelTAB.entrySet()) {	//check if the "symbol" "exists" in the symTable or not

					if (labelNameCOMMA.equals(exists.getKey())) {		//if it exists then:

						 val = (String) exists.getValue();				//initialize the address to location pointer 

						//System.out.println(exists.getKey()+": "+exists.getValue());

						label_LocationINT = Integer.parseInt(val, 16);

							

					}

					else if(labelNameCOMMA2.equals(exists.getKey())){



					}				

				}



String labelPLACE = currentLine.split("\\s+")[0];





	}

	else if (labelTAB.containsKey(labelHere)){

		for (Map.Entry exists : labelTAB.entrySet()) {	//check if the "symbol" "exists" in the symTable or not

					if (labelHere.equals(exists.getKey())) {		//if it exists then:

						 val = (String) exists.getValue();				//initialize the address to location pointer 

						//System.out.println(exists.getKey()+": "+exists.getValue());

						label_LocationINT = Integer.parseInt(val, 16);

							

					}

				}



	}





String current = currentLine.split("\\s+")[0];

currentINT = Integer.parseInt(current, 16);



int disp = currentINT-label_LocationINT;





if (disp>= -2048 && disp <= 2047 ){

	p="1";



	//System.out.println(disp);



}

else {

	b="1";

	//System.out.println("nope");

}





//first completed hex already

//conHex

//System.out.println(conHex);



//last 2 bits

String secondBit= extra +n +i; //add ni to it 01 values

//System.out.println(secondBit);

char secondHex = hexCon.hexConvert(secondBit);

//System.out.println(secondHex);





String thirdBit = x+b+p+e; //01 values

char thirdHex = hexCon.hexConvert(thirdBit);

//System.out.println(thirdHex);





//  disp is Hex now 

String dispHex = Integer.toHexString(disp);

dispHex=dispHex.toUpperCase(Locale.ENGLISH);//turns everything to uppercase.

//System.out.println(dispHex);



String opcode = conHex +""+ secondHex +""+ thirdHex +""+dispHex;



System.out.println(opcode);

String address = currentLine.split("\\s+")[0];
String textRec = "T" + address + opcode.length() + opcode;
bufferwriter.write(textRec);





}

						//output to text file in order 


}//end while loop





			bufferwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

