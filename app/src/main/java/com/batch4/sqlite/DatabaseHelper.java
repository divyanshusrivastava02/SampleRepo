package com.batch4.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divyanshu on 11-09-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //Datebase version
    private static final int DATABASE_VERSION =1;

    // DATABASE NAME

    private static final String DATABASE_NAME="ContacsManager";
    private static final  String TABLE_CONACTS = "contacts";

    //Coloums names

    private static final  String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONENUMBER = "phone_number";


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE "+TABLE_CONACTS+" ("
                +KEY_ID+" INTEGER PRIMARY KEY," +KEY_NAME+ " TEXT,"
                +KEY_PHONENUMBER+" TEXT"+")";

        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONACTS);
        onCreate(db);

    }



    void addContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contacts.get_name());
        values.put(KEY_PHONENUMBER,contacts._phone_number);
        db.insert(TABLE_CONACTS,null,values);
        db.close();
    }



    Contacts getContacts(int id){
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor  = db.query(TABLE_CONACTS, new String[]{KEY_ID,KEY_NAME,KEY_PHONENUMBER},KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if(cursor!=null)
            cursor.moveToFirst();
        Contacts contacts = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
        return  contacts;
    }

    public List<Contacts> getAllContacts(){

        List<Contacts> contactList  = new ArrayList<Contacts>();

        String selectQuery = "SELECT * FROM "+TABLE_CONACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Contacts contacts = new Contacts();
                contacts.set_id((Integer.parseInt(cursor.getString(0))));
                contacts.set_name(cursor.getString(1));
                contacts.set_phone_number(cursor.getString(2));
                contactList.add(contacts);

            }while (cursor.moveToNext());
        }

        return contactList;
    }




    public int updateContact(Contacts contacts) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contacts.get_name());
        values.put(KEY_PHONENUMBER,contacts.get_phone_number());
        return db.update(TABLE_CONACTS,values , KEY_ID + " =?",new String[]{String.valueOf(contacts.get_id())});
    }


    public void deleteContacts(Contacts contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONACTS,KEY_ID+ " =?",
                new String[]{String.valueOf(contacts.get_id())});
        db.close();
    }


    public int getContactsConts(){
        String countQuery = "SELECT * FROM "+TABLE_CONACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();
        return cursor.getCount();

    }

}
