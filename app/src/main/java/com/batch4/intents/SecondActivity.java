package com.batch4.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.batch4.R;

/**
 * Created by Divyanshu on 20-08-2016.
 */
public class SecondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_second);

//        Bundle bundle = getIntent().getExtras();
//        String name = bundle.getString("NAME");


        String name = getIntent().getStringExtra("NAME");
        boolean isRegistered = getIntent().getBooleanExtra("isRegister",false);
        int marks = getIntent().getIntExtra("marks",65);

        TextView textview1 = (TextView)findViewById(R.id.textview1);

        if(isRegistered) {
            textview1.setText("Welcome : " + name + " : " + isRegistered + " : " + marks);
        }else{
            textview1.setText("You are not registered");
        }
    }
}
