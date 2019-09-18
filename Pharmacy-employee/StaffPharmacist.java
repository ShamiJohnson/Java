/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */

public class StaffPharmacist extends Employee {
    
    public StaffPharmacist(Integer idNumber, String firstName, String lastName, Double hourlyRate) {
        super(idNumber, firstName, lastName, hourlyRate);
        idNumber = null;
        firstName = " ";
        lastName = " ";
        hourlyRate = 40.0;
        
        
        //Staff Pharmacist ( ROLE ID=2): $40/hour
        
    }
    
    //StaffPharmacist constructor
    public StaffPharmacist()
    {
        
    }
    
    public void calcHours(){
        super.hourlyRate *= hourlyRate;
        
    }
}
