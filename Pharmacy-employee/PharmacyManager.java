/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */

public class PharmacyManager extends Employee {
    
    public  PharmacyManager(Integer idNumber, String firstName, String lastName, Double hourlyRate) {
        super(idNumber, firstName, lastName, hourlyRate);
        idNumber = null;
        firstName = "";
        lastName = "";
        hourlyRate = 50.0;
        
        
        
        
        
        //Pharmacy Manager ( ROLE ID=1): $50/hour
        
        
        //PharmacyManager employee2 = new PharmacyManager(idNumber, lastName, lastName, hourlyRate);
        
        //System.out.println(employee2.getIdNumber() + "\t\t" + employee2.getFirstName() + "\t\t" + employee2.getLastName() + "\t\t" +  employee2.getHourlyRate());
        
    }
    
    public PharmacyManager() {
        
    }
    
    
    
    
    
    
    public void calcHours(double hourlyRate ){
        hourlyRate = 50.0;
        super.hourlyRate *= hourlyRate;
        
    }
    
    
}
