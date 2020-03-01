package com.example.mykotlin;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends AppCompatActivity {

        Shared_preference_con spc;
        MyDatabaseAdaptor myDatabaseAdaptor;
        RecyclerView rv;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout);
        }
}
