package org.goldclone.converter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConverterActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Resources res = getResources();
        
        ArrayList<Button> catB = new ArrayList<Button>();
        
        String[] categories = res.getStringArray(R.array.temperature);
        for (String cat : categories)
        {
        	catB.add(new Button())
        }
        
//        ArrayList<Button> categories = new ArrayList<Button>();
//        
//        for (@string-array/categories)
//        
//        final Button button = (Button) findViewById(R.id.temperatureButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View button) {
//                // Perform action on click
//            	Toast.makeText(getApplicationContext(), "Yup yup!", Toast.LENGTH_LONG).show();
//            }
//        });
    }
}