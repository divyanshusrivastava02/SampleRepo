package com.batch4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Divyanshu on 31-07-2016.
 */
public class TimePickerExample extends Activity {

    Button bt;
    TimePicker timepick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        timepick = (TimePicker)findViewById(R.id.timepicker1);
        bt = (Button)findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TimePickerExample.this,"Time Is:- "+timepick.getCurrentHour()+" : "+timepick.getCurrentMinute(),Toast.LENGTH_SHORT).show();
            }
        });

        timepick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                System.out.println("Time is: "+hour+" : "+minute);
                Toast.makeText(TimePickerExample.this,"Time is: "+ hour+" : "+minute,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
