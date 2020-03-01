package com.example.mykotlin;

import android.content.Context;
import android.content.SharedPreferences;


public class Shared_preference_con {

    private SharedPreferences sharedPreferences;
    private Context context;

    public Shared_preference_con(Context context){

        this.context=context;
        sharedPreferences=context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);



    }
    public void wr_log_stat(boolean status){
        SharedPreferences.Editor editor =sharedPreferences.edit();
        SharedPreferences.Editor editor1 = editor.putBoolean(context.getResources().getString(R.string.login_status_preference), status);
        editor.commit();

    }


    public boolean rd_log_stat() {
        boolean stat =false;
        stat=sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),false);

        return stat;
    }
}
