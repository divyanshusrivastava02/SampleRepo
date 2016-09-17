package com.batch4.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.batch4.R;

/**
 * Created by Divyanshu on 21-08-2016.
 */
public class ImplicitIntentExample extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implcit_intent);
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentView = new Intent(Intent.ACTION_VIEW);
                intentView.setData(Uri.parse("https://acadgild.com/"));
                startActivity(intentView);
            }
        });
    }
}
