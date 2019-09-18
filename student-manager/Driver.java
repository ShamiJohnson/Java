/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Driver {
    public static void main(String[] args) {
        
        int x = 0;
        int menuChoice = 0;
        
        Scanner input = new Scanner (System.in);
        
        do{
            
            System.out.println("1. Load Students (From File)");
            
            System.out.println(" 2. Print Stack ");
            
            System.out.println("3. Exit Program ");
            
            System.out.println("Enter Your Selection: ");
            menuChoice = input.nextInt();
            
            
            
            
            if (menuChoice == 1){
                
                // Create a new instance of a Stack on the Heap.
                Stack<Integer> testStack = new Stack<Integer>(10);
                
                //push file on stack
                //testStack.push(inputFile);
                
                
                File inputFile = new File("students.txt");
                String line;
                try{
                    Scanner fileReader = new Scanner(inputFile);
                    while(fileReader.hasNextLine()){		//checks if there is a next line
                        line = fileReader.nextLine();   // Reads one line from the file
                        testStack.push(inputFile);
                        System.out.println(line);
                    }
                    fileReader.close();
                    
                }catch (FileNotFoundException ex)
                {
                    System.err.println(ex);
                }
                
                
            }
            
            else if (menuChoice == 2){
                System.out.println(testStack.pop());
                
            }
            
            else if (menuChoice==2) {
                for (int i=0; i<x; i++) {
                    Student s = students[i];
                    System.out.println(s.getFirstname() + s.getLastname() + s.getGpa() 
                                       + s.getStudentID() + s.getLine1());
                }
            }
            else if(menuChoice < 1 || menuChoice > 3){
                System.out.println("Unrecognized menu choice; please re-enter");
            }
            
            
            
        }while (menuChoice != 3);
        System.out.println("Goodbye!");
        
        
        
    }
}

