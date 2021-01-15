package edu.oru.cit352.i_jones2105.mycontactlist;


/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */

//A mobile application for storing desired contact information and to readily retrieve and
//present the desired contact data for the user's convenience


//import utilities

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


import java.util.Calendar;

//class declaration
public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    //Override parental method for how to behave onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //method calls for the various functions of the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListButton();
        initMapButton();
        initSettingsButton();
        initToggleButton();
        setForEditing(false);
        initChangeDateButton();
    }

    //Method for navigating to the ContactList Page
    private void initListButton() {
        final ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });
    }

    //Method for navigating to the ContactMaps Page
    private void initMapButton() {
        ImageButton ibMap = (ImageButton) findViewById(R.id.imageButtonMap);
        ibMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    // Method for navigating to the ContactSettings Page
    private void initSettingsButton() {
        ImageButton ibSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
    }

    //Method for controlling the editToggleButton
    private void initToggleButton() {
        final ToggleButton editToggle = (ToggleButton) findViewById(R.id.toggleButtonEdit);
        editToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                setForEditing(editToggle.isChecked());
            }
        });
    }

    //Method controlling if editing is enabled
    private void setForEditing(boolean enabled) {
        EditText editName = (EditText) findViewById(R.id.editName);
        EditText editAddress = (EditText) findViewById(R.id.editAddress);

        if (enabled) {
            editName.requestFocus();
        }

    }

    //Override method for displaying the selected date
    @Override
    public void didFinishDatePickerDialog(Calendar selectedTime) {
        TextView birthDay = (TextView) findViewById(R.id.textBirthday);
        birthDay.setText(DateFormat.format("MM/dd/yyyy", selectedTime.getTimeInMillis()).toString());

    }


    //Method for controlling the changeDate button
    private void initChangeDateButton() {
        Button changeDate = (Button) findViewById(R.id.btnBirthday);
        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm, "DatePick");
            }
        });

    }
}
