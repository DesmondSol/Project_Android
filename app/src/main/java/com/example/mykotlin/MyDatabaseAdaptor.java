package com.example.mykotlin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class MyDatabaseAdaptor
{
    MyDatabaseHelper myDatabaseHelper;



    public MyDatabaseAdaptor(Context context)  //Creating a Constructor.
    {
        Log.d("Context: ", context == null ? "is null": "is not null");
        myDatabaseHelper = new MyDatabaseHelper(context);     //make a object of database helper.
    }

    public long insertData(String fname,String uname, String email,
                           String password,int mobile,String gender)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(myDatabaseHelper.FULLNAME, fname);
        contentValues.put(myDatabaseHelper.USERNAME, uname);
        contentValues.put(myDatabaseHelper.EMAIL, email);
        contentValues.put(myDatabaseHelper.PASSWORD, password);
        contentValues.put(myDatabaseHelper.MOBILE, mobile);
        contentValues.put(myDatabaseHelper.GENDER, gender);

        long id = sqLiteDatabase.insert(myDatabaseHelper.TABLE_NAME, null, contentValues);
        return id;
    }


    public Cursor getData()
    {
        boolean val=false;
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collumn = {myDatabaseHelper.ID, myDatabaseHelper.FULLNAME, myDatabaseHelper.USERNAME,
                myDatabaseHelper.EMAIL, myDatabaseHelper.PASSWORD, myDatabaseHelper.MOBILE, myDatabaseHelper.GENDER};
        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME,collumn,null, null, null, null,null);


        while (cursor.moveToNext())
        {
            String id = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.ID));
            String fname = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.FULLNAME));
            String uname = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.USERNAME));
            String email = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.EMAIL));
            String password = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.PASSWORD));
            String mobile = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.MOBILE));
            String gender = cursor.getString(cursor.getColumnIndex(MyDatabaseHelper.GENDER));
Users usr=new Users(id, fname, uname, email, password, mobile ,gender);




        }

        return cursor;
    }

    public boolean checkUser(String uname, String password)
    {
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
        String [] collomn = {myDatabaseHelper.ID};
        String selection = myDatabaseHelper.USERNAME + "=?" + " AND " + myDatabaseHelper.PASSWORD + "=?";
        String [] selectionArgs = {uname , password};

        Cursor cursor = sqLiteDatabase.query(myDatabaseHelper.TABLE_NAME , collomn, selection, selectionArgs, null, null, null);
            //checking if user exists and password is his
        int cursorCount = cursor.getCount();
        cursor.close();
        sqLiteDatabase.close();

        if(cursorCount > 0)
        {
            return true;
        }
        return  false;
    }

}
