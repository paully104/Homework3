package utasearch.paulreitz.com.homework3;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Paul on 10/23/2014.
 */
public class MySettings extends MyActivity{




    private Spinner spinner1;
    private View view1;

    public void initializevariables()
    {
        String[] country={"Options","Home", "Settings", "Server Status","Exit"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);

        Spinner spinner =
                (Spinner)  findViewById(R.id.settings_spinner);
        spinner.setAdapter(stringArrayAdapter);

        DatePicker date =(DatePicker)findViewById(R.id.datePicker);
        TimePicker time =(TimePicker)findViewById(R.id.timePicker);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        time.setCurrentHour(prefs.getInt("Hour",5));
        time.setCurrentMinute(prefs.getInt("Minute", 5));

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                    {
                        //when an item is selected
                        if(parent.getSelectedItem().toString().contains("Exit")) {
                            System.out.println("Now Exiting");
                            finish();

                        }
                        else if(parent.getSelectedItem().toString().contains("Server Status"))
                        {
                            //open server status page
                            System.out.println("Server Status");
                            FragmentManager fm = getFragmentManager();
                            MyAlertDialog alert = new MyAlertDialog();
                            alert.show(fm, "Alert_Dialog");




                        }
                        else if(parent.getSelectedItem().toString().contains("Settings"))
                        {
                            System.out.println("Settings");
                            Intent intent = new Intent(parent.getContext(), MySettings.class);
                            startActivity(intent);


// Selection of the spinner
                            //Spinner spinner = (Spinner)findViewById(R.id.settings_spinner);
                            //MySettings example = new MySettings();
                            //setContentView(R.layout.settings_my);


// Application of the Array to the Spinner

                        }
                        else if(parent.getSelectedItem().toString().contains("Home"))
                        {
                            System.out.println("Home");
                            Intent intent = new Intent(parent.getContext(), MyActivity.class);
                            startActivity(intent);

                        }
                        else if(parent.getSelectedItem().toString().contains("Login"))
                        {
                            FragmentManager fm = getFragmentManager();
                            MyAlertDialog alert = new MyAlertDialog();
                            alert.show(fm, "Alert_Dialog");


                        }




                    }
                    @Override
                    public void onNothingSelected( AdapterView<?>  parent)
                    {
                        //when nothing is selected
                        return;


                    }
                };


        spinner.setOnItemSelectedListener(onSpinner);//make the listener active

    }
    public View getView()
    {
        return getView();

    }

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_my);
        initializevariables();

        Button b = (Button)findViewById(R.id.SaveButton);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DatePicker date = (DatePicker) findViewById(R.id.datePicker);
                TimePicker time = (TimePicker) findViewById(R.id.timePicker);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplication());
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("Hour",time.getCurrentHour().toString());
                edit.putString("Minute",time.getCurrentMinute().toString());
                edit.commit();
            }
        });


        //stuff that actually works...
        DatePicker date =(DatePicker)findViewById(R.id.datePicker);
        TimePicker time =(TimePicker)findViewById(R.id.timePicker);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

       time.setCurrentHour(prefs.getInt("Hour",5));
        time.setCurrentMinute(prefs.getInt("Minute", 5));
       // time.setCurrentMinute(Calendar.MINUTE);









    }



}
