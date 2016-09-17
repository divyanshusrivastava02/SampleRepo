package com.batch4;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Divyanshu on 30-07-2016.
 */
public class WidgetsExample extends Activity{

    EditText et_username;
    EditText et_password;
    CheckBox checkBox1;
    RadioButton radioButton1,radioButton2;
    Spinner spinner;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);

        et_username = (EditText)findViewById(R.id.et_username);
        et_password = (EditText)findViewById(R.id.et_password);

        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);

        radioButton1 = (RadioButton)findViewById(R.id.rb_monthly);
        radioButton2 = (RadioButton)findViewById(R.id.rb_yearly);

        spinner = (Spinner)findViewById(R.id.spinner1);
        button = (Button)findViewById(R.id.btn_submit);
        spinner.setVisibility(View.INVISIBLE);



        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox1.isChecked()==false){
                    spinner.setVisibility(View.INVISIBLE);

                    Toast.makeText(WidgetsExample.this,"Check box click false",Toast.LENGTH_SHORT).show();
                }else{
                    spinner.setVisibility(View.VISIBLE);
                    Toast.makeText(WidgetsExample.this,"Check box click True",Toast.LENGTH_SHORT).show();
                }
            }
        });


        radioButton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(radioButton1.isChecked()== true){
                    Toast.makeText(WidgetsExample.this,"Radio Button is Checked , We are changing",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WidgetsExample.this,"Radio Button is UnChecked , We are changing",Toast.LENGTH_SHORT).show();

                }

            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(WidgetsExample.this,"You have selected: "+spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    String usename = et_username.getText().toString();
                    String password = et_password.getText().toString();
                    String spinnervalue = spinner.getSelectedItem().toString();
                    int lengthVal = Integer.parseInt(usename);
                    if (usename.length() < 5) {
                        et_username.setError("Please enter right number");
                    }

                    Toast.makeText(WidgetsExample.this,"Button CLICK Called" +" "+usename+" "+password+" "+spinnervalue,Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

//        button.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Toast.makeText(WidgetsExample.this,"Button setOnTouchListener Called",Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                et_username.setText("");
                et_password.setText("");
                Toast.makeText(WidgetsExample.this,"Button setOnLongClickListener Called",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
