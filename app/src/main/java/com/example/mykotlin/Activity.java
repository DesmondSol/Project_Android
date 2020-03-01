package com.example.mykotlin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity extends AppCompatActivity {

    EditText fname;
    EditText uname;
    EditText email;
    EditText password;
    EditText mobile;
    EditText gender;



    MyDatabaseAdaptor myDatabaseAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.f_name);
        uname = findViewById(R.id.u_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mobile = findViewById(R.id.mobile);
        gender = findViewById(R.id.gender);


    }


public void goBack(View view){
        finish();
}
    public void addUser(View view)
    {
        String s1 = fname.getText().toString();
        String s2 = uname.getText().toString();
        String s3 = email.getText().toString();
        String s4 = password.getText().toString();
        String s7 = mobile.getText().toString();
        String s8 = gender.getText().toString();

        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() ||s7.isEmpty() || s8.isEmpty() ) {
            Toast.makeText(this, "Please Fill in all the items!!!!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            myDatabaseAdaptor=new MyDatabaseAdaptor(Activity.this);
            long id = myDatabaseAdaptor.insertData(s1, s2, s3, s4, Integer.parseInt(s7), s8);

            if (id <= 0) {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
                fname.setText("");
                uname.setText("");
                email.setText("");
                password.setText("");
                mobile.setText("");
                gender.setText("");

            } else {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                fname.setText("");
                uname.setText("");
                email.setText("");
                password.setText("");
                mobile.setText("");
                gender.setText("");
            }

        }
    }


}
