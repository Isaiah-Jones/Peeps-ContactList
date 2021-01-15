package edu.oru.cit352.i_jones2105.mycontactlist;

/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */

//Connect the application to a database that stores all contact data

//import utilities

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;


//class declaration
public class ContactDataSource {

    //Global variables for accessing the database
    private SQLiteDatabase database;
    private ContactDBHelper dbHelper;

    //Constructor that establishes the database which the app connects to
    public ContactDataSource(Context context) {
        dbHelper = new ContactDBHelper(context);
    }

    //Method that opens the connection to the database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //Method for closing the connection to the database
    public void close() {
        dbHelper.close();
    }


    //Method for inserting a new contact into the database
    public boolean insertContact(Contact c) {
        boolean didSucceed = false;

        //try-catch for inserting data in its proper format into the database
        try {
            ContentValues initialValues = new ContentValues();

            initialValues.put("contactname", c.getContactName());
            initialValues.put("streetaddress", c.getStreetAddress());
            initialValues.put("city", c.getCity());
            initialValues.put("state", c.getState());
            initialValues.put("zipcode", c.getZipCode());
            initialValues.put("phonenumber", c.getPhoneNumber());
            initialValues.put("cellnumber", c.getCellNumber());
            initialValues.put("email", c.geteMail());
            initialValues.put("birthday", String.valueOf(c.getBirthday().getTimeInMillis()));

            didSucceed = database.insert("contact", null, initialValues) > 0;

        } catch (Exception e) {
            //If insertion is unsuccessful Do nothing
        }
        return didSucceed;
    }

    //Method for updating a pre-existing contact
    public boolean updateContact(Contact c) {
        boolean didSucceed = false;

        //try-catch for inserting data in its proper format into the database
        try {
            Long rowId = (long) c.getContactID();
            ContentValues updateValues = new ContentValues();

            updateValues.put("contactname", c.getContactName());
            updateValues.put("streetaddress", c.getStreetAddress());
            updateValues.put("city", c.getCity());
            updateValues.put("state", c.getState());
            updateValues.put("zipcode", c.getZipCode());
            updateValues.put("phonenumber", c.getPhoneNumber());
            updateValues.put("cellnumber", c.getCellNumber());
            updateValues.put("email", c.geteMail());
            updateValues.put("birthday", String.valueOf(c.getBirthday().getTimeInMillis()));

            didSucceed = database.update("contact", updateValues, "_id=" + rowId, null) > 0;
        } catch (Exception e) {
            //If insertion is unsuccessful Do nothing
        }
        return didSucceed;
    }

    //
    public int getLastContactId() {
        int lastId = -1;
        try {
            String query = "Select MAX(_id) from contact";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }
}