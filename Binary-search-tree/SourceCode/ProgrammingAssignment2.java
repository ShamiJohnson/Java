import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * CSCI 36200: Data Structures
 * Programming Assignment 2
 * Instructor: Dr. Snehasis Mukhopadhyay
 * Due date: March 20, 2018
 * 
 * Description:
 * The program builds a cross-reference index
 * by using Binary search tree (or Lexicographic Tree)
 * Each node of tree contains a word and a linked list of
 * lines that store that word
 * 
 * Processing:
 *   Create a tree
 *   while has word from file
 *         add word with current line to tree
 *   end while
 *   print tree
 *   
 * Input:
 *   file name from standard input
 *   words from file
 *   
 * Output:
 *   tree is printed in standard output
 */
public class ProgrammingAssignment2 {

	/**
	 * current line
	 */
	private static int line = 1; //first line is 1
	
	/**
	 * maximum number of length of word
	 */
	private static final int MAX_WORD_LEN = 10;
	
	/**
	 * end of file character
	 */
	private static final char END_OF_FILE_CHAR = '#';
	
	/**
	 * a letter from stream
	 */
	private static char current = ' ';
	
	/**
	 * read a word from stream
	 * 
	 * @param fileInputStream file input stream
	 * @return a word
	 * @throws IOException
	 */
	public static String nextWord(FileInputStream fileInputStream) throws IOException{
		
		//found end of file
		if (current == END_OF_FILE_CHAR){
			return String.valueOf(END_OF_FILE_CHAR);
		}
		
		//a word
		String word = "";
		
		//ignore until get the first letter or #
		while (fileInputStream.available() > 0){
			current = (char)fileInputStream.read();
			
			//new line
			if (current == '\n'){
				line++;
			}
			
			if (Character.isLetter(current)){
				word += current;
				break;
			}else if (current == END_OF_FILE_CHAR){
				break;
			}
		}
		
		//return "#" as end of file
		if (word.length() == 0){
			return nextWord(fileInputStream);
		}
		
		//got word
		if (word.length() > 0 && current == END_OF_FILE_CHAR){

			//characters beyond 10 in a word are ignore
			if (word.length() > MAX_WORD_LEN){
				word = word.substring(0, MAX_WORD_LEN);
			}
			return word;
		}
			
		
		//consume the next character until it is not letter or digit
		while (fileInputStream.available() > 0){
			current = (char)fileInputStream.read();
			
			//new line
			if (current == '\n'){
				line++;
			}
			
			if (Character.isLetterOrDigit(current)){
				word += current;				
			}else{
				break;
			}
		}
		
		//characters beyond 10 in a word are ignore
		if (word.length() > MAX_WORD_LEN){
			word = word.substring(0, MAX_WORD_LEN);
		}
		return word;
	}
	
	/**
	 * build cross-reference index
	 * @return Lexicographic tree
	 * @throws IOException 
	 */
	public static LexicographicTree buildCrossReferenceIndex(FileInputStream fileInputStream) throws IOException{
		
		//create empty Lexicographic Tree
		LexicographicTree tree = new LexicographicTree();
		
		//read first word
		String word = nextWord(fileInputStream);
		while (!word.equals("#")){
		
			//add word to binary search tree
			tree.add(word, line);
			
			//read next word
			word = nextWord(fileInputStream);
		}
		return tree;
	}
	
	/**
	 * main method to start java application
	 * @param args the program argument
	 */
	public static void main(String[] args) {
				
		//create Scanner object to read file name
		Scanner keyboard = new Scanner(System.in);
		
		//read input file name
		System.out.print("Please enter input file name: ");
		String inputFileName = keyboard.nextLine();
		
		//read output file name
		System.out.print("Please enter output file name: ");
		String outputFileName = keyboard.nextLine();
		
		try {
			FileInputStream fileInputStream = new FileInputStream(inputFileName);
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));
			
			//build tree
			LexicographicTree tree =  buildCrossReferenceIndex(fileInputStream);
			
			//close file
			fileInputStream.close();
			
			//print tree
			tree.inorder(bufferedWriter);	
			
			//close file
			bufferedWriter.close();
			
			//done
			System.out.println("The Lexicographic Tree was written to file " + outputFileName);
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file " + inputFileName);
		}catch (IOException e) {
			System.out.println("Could not read file " + inputFileName + " or write file " + outputFileName);
		}
		
		//close scanner
		keyboard.close();
		
	}//end main
}//end class
