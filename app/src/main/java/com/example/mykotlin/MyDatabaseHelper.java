package com.example.mykotlin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "userManagement";
    public static final String DATABASE_VERSION = "1";
    public static final String TABLE_NAME = "userLogin";

    public static final String ID = "id";
    public static final String FULLNAME = "fname";
    public static final String USERNAME = "uname";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String MOBILE = "mobile";
    public static final String GENDER = "gender";


    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FULLNAME+" VARCHAR(30),"
            +USERNAME+" VARCHAR(20)," +EMAIL+" VARCHAR(50), "+PASSWORD+" VARCHAR(20),"+MOBILE+" INTEGER,"+GENDER+" VARCHAR(10));";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, Integer.parseInt(DATABASE_VERSION));
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        try
        {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onCreate method");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        try
        {
            sqLiteDatabase.execSQL(DROP_TABLE);
        }
        catch (Exception e)
        {
            System.out.println("Error in onUpgrade method");
        }
    }







    public int delete(String del){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME,"where E_MAIL=?",new String[]{del});
    }

    public Cursor usernamePassword() {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select "+USERNAME+","+PASSWORD +" from "+TABLE_NAME, null);
        return res;
        // Toast.makeText(this,res,Toast.LENGTH_LONG).show();

    }
    public Cursor fetchAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
        return cursor;
    }


}


