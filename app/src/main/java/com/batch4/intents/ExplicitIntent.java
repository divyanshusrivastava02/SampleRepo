package com.batch4.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.batch4.R;

/**
 * Created by Divyanshu on 20-08-2016.
 */
public class ExplicitIntent extends Activity{

    EditText edittxt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_explicit_intent);

        edittxt1 =  (EditText)findViewById(R.id.edittxt1);
        Button BTN1 = (Button)findViewById(R.id.BTN1);
        BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Bundle bundle = new Bundle();

                String val = edittxt1.getText().toString();
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
//                bundle.putString("NAME",val);
//                intent.putExtras(bundle);

                intent.putExtra("NAME",val); // String
                intent.putExtra("isRegister",true); //boolean
                intent.putExtra("marks",34); // Integer

                startActivity(intent);
            }
        });
    }
}
