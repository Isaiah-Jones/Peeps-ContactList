package edu.oru.cit352.i_jones2105.mycontactlist;

/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */


//Control the functions of the ContactMap Page of the application

//import utilities
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

//class declaration
public class ContactMapActivity extends AppCompatActivity {

    //Override parent method for what to do when this the ContactMap Page is selected
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_map);
        initListButton();
        initMapButton();
        initSettingsButton();
    }

    //Method for navigating to the ContactList Page
    private void initListButton(){
        final ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactMapActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });
    }
    //Method for disabling the ContactMap button while on the ContactMap Page
    private void initMapButton(){
        ImageButton ibMap = (ImageButton) findViewById(R.id.imageButtonMap);
        ibMap.setEnabled(false);


    }

    //Method for navigating to the ContactSettings Page
    private void initSettingsButton(){
        ImageButton ibSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactMapActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }
}
