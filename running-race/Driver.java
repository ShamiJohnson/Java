/*Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 *
 * Ehtsham Nisar
 *
 */


import java.io.*;
import java.util.Scanner;

public class Driver{
    public static void main(String[] args){
        System.out.println("Welcome to our CSCI 240 Roster Editor!");
        System.out.println("1) Add New Player");
        System.out.println("2) View Player(s)");
        System.out.println("3) Exit Program");
        System.out.println("Please enter your selection:");
        Scanner selection = new Scanner (System.in);
        String s;  // creating a string variable
        s = selection.next(); //users input will be stored in s

        if (s.equals("1"))
            System.out.println("Please enter a first name: /n Please enter a last name: /n Please enter a number (1-99): ");
        
        else
            if (s.equals(2))
            System.out.println(s); //printing out storedstring
        else
            if (s.equals("3")) //exit loop
                break;
        
        
        //Driver s1 = new Driver();
    
    }
    

}
