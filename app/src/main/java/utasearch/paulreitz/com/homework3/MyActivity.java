package utasearch.paulreitz.com.homework3;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class MyActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



        final TextView textView = (TextView)findViewById(R.id.textView);
        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);


        // Initialize the textview with '0'.
        textView.setText("Volume: " + seekBar.getProgress() + "/" + seekBar.getMax());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                Toast.makeText(getApplicationContext(), "Changing Volume", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Volume: " + progress + "/" + seekBar.getMax());
                //Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });


    // A private method to help us initialize our variables.









        //Spinner Selection
        String[] country={"Options","Login", "Settings", "Server Status","Exit"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);

        Spinner spinner =
                (Spinner)  findViewById(R.id.spinner);
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
                        else if(parent.getSelectedItem().toString().contains("Login"))
                        {
                            //FragmentManager fm = getFragmentManager();
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

        WebView webview = (WebView)this.findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl("http://carnival.guildwork.com/");




    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


