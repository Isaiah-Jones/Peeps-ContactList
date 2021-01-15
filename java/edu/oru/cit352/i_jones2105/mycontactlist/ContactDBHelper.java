package edu.oru.cit352.i_jones2105.mycontactlist;


/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */

//A program that creates and manages the contact database for the app

//import utilities
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


//Class declarations and static class variables
public class ContactDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION = 1;

    // SQL database creation command
    private static final String CREATE_TABLE_CONTACT =
            "create table contact (_id integer primary key autoincrement, "
                    + "contactname text not null, streetaddress text, "
                    + "city text, state text, zipcode text, "
                    + "phonenumber text, cellnumber text, "
                    + "email text, birthday text);";

    //Constructor that declares the parent class
    public ContactDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Override the parental method for how to behave onCreate
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_CONTACT);
    }

    //Override the parental method for how to behave onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(ContactDBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }

}
