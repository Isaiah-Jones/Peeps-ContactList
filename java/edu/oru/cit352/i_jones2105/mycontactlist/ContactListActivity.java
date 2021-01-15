package edu.oru.cit352.i_jones2105.mycontactlist;

/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */


//Control the functions of the ContactList Page of the application

//import utilities

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//class declaration
public class ContactListActivity extends AppCompatActivity {

    //Override parent method for what to do when this the contactList is selected
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        initListButton();
        initMapButton();
        initSettingsButton();

    }

    //Method for disabling the ContactList button while on the ContactList Page
    private void initListButton() {
        final ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setEnabled(false);

    }

    //Method for navigating to the ContactMap Page
    private void initMapButton() {
        ImageButton ibMap = (ImageButton) findViewById(R.id.imageButtonMap);
        ibMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactListActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    //Method for the navigating to the ContactSettings Page
    private void initSettingsButton() {
        ImageButton ibSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactListActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }
}
