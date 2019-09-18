/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Driver {
    public static void main(String[] args) {
        
        int menuChoice = 0;
        int secondMenuChoice = 0;
        Scanner input = new Scanner (System.in);
        int hoursWorked = 2;
        
        PharmacyManager pharmManager = new PharmacyManager();
        StaffPharmacist pharmStaff = new StaffPharmacist();
        StaffTechnician techStaff = new StaffTechnician();
        SeniorTechnician techSenior = new SeniorTechnician();
        
        
        
        
        
        //loading student menu
        
        System.out.println("1. Load Employees (From File)");
        System.out.println(" 2. Exit Program");
        System.out.print("Enter Your Selection: ");
        menuChoice = input.nextInt();
        
        
        File inputFile = new File("employees.txt");
        String line;
        
        
        if (menuChoice == 1){
            
            boolean success = true; //so you can throw a message saying everything went good
            try{
                Scanner fileReader = new Scanner(inputFile);
                
                while(fileReader.hasNextLine()){		//checks if there is a next line
                    line = fileReader.nextLine();   // Reads one line from the file
                    success = true;
                    
                    
                    
                    //System.out.println(line);   //Should be in the print line method so probable in the option 2. if the user picks this then print all
                }
                fileReader.close(); //closing reading the file
                
                
            }catch (FileNotFoundException ex) //if something goes wrong throws your message
            
            {
                System.err.println("File Load Failed!");
                System.err.println("java.io.FileNotFoundException: employees.txt (The system cannot find the file specified)");
                System.err.println(" ");
                System.err.println("Program Exiting...");
                
            }finally{
                if(success)
                    System.out.println("\nFile Successfully Loaded!\n");
                
                
            }
        }
        
        else if (menuChoice ==2){
            System.out.println("Goodbye!");
            System.exit(0);
            
            
        }
        else{
            //do while loop continues until the user picks 4
            do{
                System.out.println("1. Print Employee Information");
                System.out.println("2. Enter Hours Worked");
                System.out.println("3. Calculate Paychecks ");
                System.out.println("4. Exit Program");
                System.out.print("Enter Your Selection: ");
                
                
                
                secondMenuChoice = input.nextInt();
                if(secondMenuChoice == 1)
                {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("ID: 90000123	Name: John Jones 	  Rate: 50	 Licensed: true		Has Leadership: true ");
                    System.out.println("ID: 90012342 	Name: Crystal Konrad  Rate: 40 	 Licensed: true ");
                    System.out.println("ID: 90001234 	Name: Brittany Willis Rate: 25   Has Degree: true 	Has Service Award: true");//method goes here
                    System.out.println("ID: 90006783 	Name: Tim Duncan	  Rate: 20    Has Degree: true ");
                    System.out.println("");
                    
                }
                
                if(secondMenuChoice == 2) //scan the int value and multiply it by the hourly rate
                {
                    System.out.println("");
                    System.out.println("");
                    System.out.print("Please enter the hours worked: ");
                    hoursWorked =input.nextInt();
                    System.out.println("");
                    System.out.println("");
                    
                    
                }
                if(secondMenuChoice == 3) //print the calculated hours
                {
                    System.out.println("ID: 90000123 Check Amount: ");
                    System.out.println("ID: 90012342 Check Amount: ");
                    System.out.println("ID: 90001234 Check Amount: ");
                    System.out.println("ID: 90006783 Check Amount: ");
                    
                    System.out.println("");
                    System.out.println("");
                    System.out.println("Calculate hours");
                    
                    System.out.println("");
                }
                
                if(menuChoice < 1 || menuChoice > 4)
                {
                    System.out.println("Unrecognized menu choice; please re-enter 1, 2, 3, 4");
                }
            }while (secondMenuChoice != 4); // the loop keeps going until the user picks 4
            
            
        }
        
        
    }
    
    
    
    
}










/*
 
 
 
 
 //Use the scanner to get the specific line by using the .get() method and then store that line in the new objects you are creating like for the pharmStaff, ect.
 try {
	String firstline = Files.readAllLines(Paths.get("employees.txt")).get(1);
	String secondline = Files.readAllLines(Paths.get("employees.txt")).get(2);
	String thirdline = Files.readAllLines(Paths.get("employees.txt")).get(3);
	String fourthline = Files.readAllLines(Paths.get("employees.txt")).get(4);
	//String fifthline = Files.readAllLines(Paths.get("employees.txt")).get(5);
	//System.out.println(firstline);
	
 } catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
 }
 
 */






















