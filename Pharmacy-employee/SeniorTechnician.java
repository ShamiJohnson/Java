/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */

public class SeniorTechnician extends Employee {
    
    
    public SeniorTechnician(Integer idNumber, String firstName, String lastName, Double hourlyRate) {
        super(idNumber, firstName, lastName, hourlyRate);
        idNumber = 0;
        firstName = "";
        lastName = "";
        hourlyRate = 25.0;
        
        
        //Senior Technician (ROLE ID=4): $25/hour
        
        
    }
    
    public SeniorTechnician(){
        
    }
    
    
    public void calcHours(){
        super.hourlyRate *= hourlyRate;
        
    }
}
