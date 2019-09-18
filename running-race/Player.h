/*Honor Pledge: I pledge that I have neither given, nor received any help on this assignment.
 *
 * Ehtsham Nisar
 *
 */



#include <iostream>
#include <string>

class Roster{
private:
    string FirstName;
    string LastName;
    string JerseyNum;
    
public:
    void setFirstName(string);
    void setLastName (string);
    void setJerseyNum (string);
    
    string getFirstName();
    string getLastName();
    string getJerseyNum();
    
    Roster();
    
};

