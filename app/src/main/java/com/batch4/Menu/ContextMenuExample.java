package com.batch4.Menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.batch4.R;

/**
 * Created by Divyanshu on 27-08-2016.
 */
public class ContextMenuExample extends Activity{

    ListView listView1;
    String contacts[] = {"Prateek","Shahsank","Praveen", "Divyanshu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contextmenu);

        listView1 = (ListView)findViewById(R.id.listview1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,contacts);
        listView1.setAdapter(adapter);

        registerForContextMenu(listView1);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Acadgild");
        menu.add(0,v.getId(),0,"Call");//groupID,item id,order,title
        menu.add(0,v.getId(),0,"SMS");
        menu.add(0,v.getId(),0,"SMS2");
        menu.add(0,v.getId(),0,"SMS3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="Call"){
            Toast.makeText(ContextMenuExample.this,"You click call",Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(ContextMenuExample.this,"You click SMS",Toast.LENGTH_SHORT).show();
        }
        else {
            return false;
        }
        return true;
    }
}
