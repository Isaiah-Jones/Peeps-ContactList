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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

//class declaration
public class ContactSettingsActivity extends AppCompatActivity {

    //Override parent method for what to do when this the contactSettings Page is selected
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_settings);
        initListButton();
        initMapButton();
        initSettingsButton();
        initSettings();
        initSortByClick();
        initSortOrderClick();
    }


    //Method for implementing the user's preferred settings for the app
    private void initSettings() {
        String sortBy = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("sortfield", "contactname");
        String sortOrder = getSharedPreferences("MyContactListPreferences",
                Context.MODE_PRIVATE).getString("sortorder", "ASC");

        //Locate radio buttons
        RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
        RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
        RadioButton rbBirthday = (RadioButton) findViewById(R.id.radioBirthday);

        //Control for the radio button selections
        if (sortBy.equalsIgnoreCase("contactname")) {
            rbName.setChecked(true);
        } else if (sortBy.equalsIgnoreCase("city")) {
            rbCity.setChecked(true);
        } else {
            rbBirthday.setChecked(true);
        }

        //Locate radio buttons
        RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
        RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);

        //Control for the radio button selections
        if (sortBy.equalsIgnoreCase("ASC")) {
            rbAscending.setChecked(true);
        } else {
            rbDescending.setChecked(true);
        }

    }

    //Method for selecting the desired sorting preference
    private void initSortByClick() {
        RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.sortPrefList);
        rgSortBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
                RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
                if (rbName.isChecked()) {
                    getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "contactname").commit();
                } else if (rbCity.isChecked()) {
                    getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "city").commit();
                } else {
                    getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortfield", "birthday").commit();
                }
            }
        });
    }

    //Method for selecting the desired order
    private void initSortOrderClick() {
        RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.orderPrefList);
        rgSortOrder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
                if (rbAscending.isChecked()) {
                    getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortorder", "ASC").commit();
                } else {
                    getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).edit().putString("sortorder", "DESC").commit();
                }
            }
        });
    }


    //Method for navigating to the ContactMap Page
    private void initListButton() {
        final ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ibList.setEnabled(false);
                Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });
    }


    //Method for navigating to the ContactMap Page
    private void initMapButton() {
        ImageButton ibMap = (ImageButton) findViewById(R.id.imageButtonMap);
        ibMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    //Method for disabling the ContactSettings Button while on the ContactSettings Page
    private void initSettingsButton() {
        ImageButton ibSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibSettings.setEnabled(false);
    }
}
