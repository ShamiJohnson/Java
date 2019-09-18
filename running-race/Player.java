/*Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 *
 * Ehtsham Nisar
 *
 */



public class Player
{
    String FirstName; // making name a string for user input
    String LastName; // making name a string for user input
    int JerseyNum; //making number an int so the user can only enter numbers
    
    
    public String getFirstName(){ //making the string public so other functions will have access to it
        return FirstName;
    }
    
    public String getLastName(){   //making the string public so other functions will have access to it

        return LastName;
    }
    
    public int getJerseyNum(){    //making the string public so other functions will have access to it

        return JerseyNum;
    }
    
    public void setFirstName(String first){     //making the string public so other functions will have access to it

        FirstName = first;
    }
    public void setLastName(String last){    //making the string public so other functions will have access to it

        LastName = last;
    }
    
    
    public void setJerseyNum(int num)   //making the string public so other functions will have access to it

    {
        JerseyNum = num;
    }

}
