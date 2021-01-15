package edu.oru.cit352.i_jones2105.mycontactlist;

/*
 * Isaiah Jones (with J. Bryan Osborne)
 * CIT 352 Mobile Application Development
 * Mr. Osborne
 * 2-17-2020
 */

//Control the date selection function for the app

//import utilities

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;


//class declaration
public class DatePickerDialog extends DialogFragment {

    public interface SaveDateListener {
        void didFinishDatePickerDialog(Calendar selectedTime);
    }

    //Empty Constructor
    public DatePickerDialog() {
    }

    //Override parent method for functioning when created
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {                                           //4
        final View view = inflater.inflate(R.layout.select_date, container);

        getDialog().setTitle("Select Date");
        final DatePicker dp = (DatePicker) view.findViewById(R.id.birthdayPicker);

        Button saveButton = (Button) view.findViewById(R.id.buttonSelect);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Calendar selectedTime = Calendar.getInstance();
                selectedTime.set(dp.getYear(), dp.getMonth(), dp.getDayOfMonth());
                saveItem(selectedTime);
            }
        });
        Button cancelButton = (Button) view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return view;
    }

    //Method for saving the user's selected date
    private void saveItem(Calendar selectedTime) {
        SaveDateListener activity = (SaveDateListener) getActivity();
        activity.didFinishDatePickerDialog(selectedTime);
        getDialog().dismiss();

    }
}
