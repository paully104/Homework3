package utasearch.paulreitz.com.homework3;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

/**
 * Created by Paul on 10/24/2014.
 */
public class MyLogin extends MyActivity {
    //
    public void initializevariables()
    {
        String[] country={"Options","Home", "Settings", "Server Status","Exit"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);

        Spinner spinner =
                (Spinner)  findViewById(R.id.LoginSpinner);
        spinner.setAdapter(stringArrayAdapter);


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
                           // FragmentManager fm = getFragmentManager();
                            //MyAlertDialog alert = new MyAlertDialog();
                            //alert.show(fm, "Alert_Dialog");
                            System.out.println("Login");
                            Intent intent = new Intent(parent.getContext(), MyLogin.class);
                            startActivity(intent);

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


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_my);
        initializevariables();

        WebView webview = (WebView)this.findViewById(R.id.LoginWebView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl("https://carnival.guildwork.com/login");







    }
}
