/*
 Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 Ehtsham Nisar
 */

public class Employee {
    
    private Integer idNumber;
    private String firstName;
    private String lastName;
    protected Double hourlyRate;
    
    
    public Employee(Integer idNumber, String firstName, String lastName, Double hourlyRate)
    {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
    }
    
    //employee constructor
    public Employee()
    {
        
    }
    
    
    
    
    //Getters  //Accessors
    //idNumber getter
    public Integer getIdNumber() {
        return idNumber;
    }
    //first name getter
    public String getFirstName() {
        return firstName;
    }
    //last name getter
    public String getLastName() {
        return lastName;
    }
    //hourly rate getter
    public Double getHourlyRate() {
        return hourlyRate;
    }
    
    
    
    //Setters  //Mutators
    
    //idNumber setter
    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }
    //first name setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //last name setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //hourly rate setter
    public void setHourlyRate(Double hourlyRate) {
        
        this.hourlyRate = hourlyRate;
        
    }
    
    
    
}




/*
 @Override // indicates that this method overrides a superclass method
 public String toString()
 {
 return String.format("%s: %s %s%n%s: %s %s%n%s: %s %s%n%s: %s %s", "ID", "90000123", PharmacyManager.calcHours(),);
 }
 */


