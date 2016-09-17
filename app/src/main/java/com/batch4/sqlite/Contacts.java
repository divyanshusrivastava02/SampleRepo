package com.batch4.sqlite;

/**
 * Created by Divyanshu on 11-09-2016.
 */
public class Contacts {
    int _id;
    String _name;

   public  Contacts(){

    }

    public Contacts(String name, String phonenumber){
        this._name = name;
        this._phone_number = phonenumber;
    }

    public Contacts(int id, String name, String phonenumber){
        this._id = id;
        this._name = name;
        this._phone_number = phonenumber;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    String _phone_number;
}
