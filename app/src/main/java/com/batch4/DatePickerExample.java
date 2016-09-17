package com.batch4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Divyanshu on 31-07-2016.  test shashank test again from url
 */
public class DatePickerExample extends Activity {

    DatePicker date;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapicker);

        date = (DatePicker)findViewById(R.id.datepicker1);
        bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DatePickerExample.this,"Date is: "+date.getDayOfMonth()+"-"+(date.getMonth()+1)+"-"+date.getYear(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
