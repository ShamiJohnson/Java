/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */

public class StaffTechnician extends Employee {
    
    public StaffTechnician(Integer idNumber, String firstName, String lastName, Double hourlyRate) {
        super(idNumber, firstName, lastName, hourlyRate);
        idNumber = null;
        firstName = "";
        lastName = " ";
        hourlyRate = 20.0;
        //Staff Technician ( ROLE ID=3): $20/hour
        
    }
    
    //StaffTechnician constructor
    public StaffTechnician(){
        
    }
    
    
    public void calcHours(){
        super.hourlyRate *= hourlyRate;
        
    }
}
