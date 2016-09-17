package com.batch4.listview.exmp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.batch4.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divyanshu on 31-07-2016.
 */
public class Listview2 extends Activity{

    List<String> li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);
        final RelativeLayout rl = (RelativeLayout)findViewById(R.id.rl);

        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,
                (int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 10;
        params.topMargin =120;

        final ListView listview = new ListView(Listview2.this);

        li = new ArrayList<String>();
        li.add("Item 1");
        li.add("Item 2");
        li.add("Item 3");
        li.add("Item 4");
        li.add("Item 5");
        li.add("Item 6");
        li.add("Item 7");
        li.add("Item 8");
        li.add("Item 9");
        li.add("Item 10");
        li.add("Item 11");
        li.add("Item 12");
        li.add("Item 13");
        li.add("Item 14");
        li.add("Item 15");
        li.add("Item 16");

        Button showlist = (Button)findViewById(R.id.button1);
        showlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayAdapter<String> adapter = new ArrayAdapter<String>( getBaseContext(),
                        android.R.layout.simple_dropdown_item_1line,li);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                listview.setAdapter(adapter);
                listview.setLayoutParams(params);
                rl.addView(listview);
            }
        });

    }
}
