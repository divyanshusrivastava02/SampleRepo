package com.batch4.sqlite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.batch4.R;

import java.util.List;

/**
 * Created by Divyanshu on 11-09-2016.
 */
public class AndroidSqliteActivity extends Activity {
    TextView name;
    TextView number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

         name = (TextView)findViewById(R.id.name);
         number = (TextView)findViewById(R.id.phone);
        DatabaseHelper db = new DatabaseHelper(this);

        System.out.println("INSERTING VALUESSSS::::::::::");

        db.addContacts(new Contacts("Mr OBAMA","+01-8374487382"));
        db.addContacts(new Contacts("Mr SARUKH","+91-7836274632"));
        db.addContacts(new Contacts("Mr MODI","+40-873484783"));

        System.out.println("READING ALL CONTACTS  VALUESSSS::::::::::");

        List<Contacts> contacts = db.getAllContacts();
        for(Contacts cn :contacts){
            String val = "ID : "+cn.get_id()+ " NAME: "+cn.get_name()+" Phonenumber: "+cn.get_phone_number();
            System.out.println("FINAL VALUES::::"+val);

            name.setText(cn.get_name());

            number.setText(cn.get_phone_number());


        }


    }
}
