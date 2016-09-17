package com.batch4.listview.exmp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.batch4.R;

/**
 * Created by Divyanshu on 31-07-2016.
 */
public class ListViewCustom extends Activity {

    ListView lv;
    Context context;
    public static int[] images = {R.drawable.food,
            R.drawable.home,
            R.drawable.food,
            R.drawable.home,
            R.drawable.food,
            R.drawable.home,
            R.drawable.food,
            R.drawable.home,
            R.drawable.food,
            R.drawable.home};
    public  static String[] resultsTXT ={"Boomika", "Prateek","Shashank","Praveen","Divyanshu","Boomika", "Prateek","Shashank","Praveen","Divyanshu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_custom);

        context = this;

        lv  = (ListView)findViewById(R.id.listview1);
        lv.setAdapter(new AdapterListview(this,resultsTXT,images));

    }
}
