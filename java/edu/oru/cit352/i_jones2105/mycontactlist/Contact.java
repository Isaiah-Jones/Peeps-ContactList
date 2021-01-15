package edu.oru.cit352.i_jones2105.mycontactlist;

/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */

//Set the context for what attributes will be collected and stored for each contact
// and methods for displaying this information

//import utilities
import java.util.Calendar;

//class declaration and class variables
public class Contact {
    private int contactID;
    private String contactName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String cellNumber;
    private String eMail;
    private Calendar birthday;

// No-arg constructor
    //contactID set to negative one to show an empty set to the auto-increment feature
    public Contact() {
        contactID = -1;
        birthday = Calendar.getInstance();
    }

    //getters for each contact variable
    public String getContactName() {
        return contactName;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public int getContactID() {
        return contactID;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getCity() {
        return city;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getState() {
        return state;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }
}


