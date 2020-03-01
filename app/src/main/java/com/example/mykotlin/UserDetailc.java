package com.example.mykotlin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailc extends AppCompatActivity {

    TextView id,name,fname,pass,email,mob,gend;
  Users usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);

        id=findViewById(R.id.idd);
        name =findViewById(R.id.unamee);
        fname =findViewById(R.id.fnamee);
        pass =findViewById(R.id.passs);
        email =findViewById(R.id.emaill);
        mob =findViewById(R.id.mobii);
        gend =findViewById(R.id.genn);



        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        Users userModel=(Users) bundle.get("user");
        id.setText(usr.getID());
       fname.setText(usr.getFULLNAME());
       name.setText(usr.getUSERNAME());
       email.setText(usr.getEMAIL());
       pass.setText(usr.getPASSWORD());
       mob.setText(usr.getMOBILE());
       gend.setText(usr.getGENDER());


    }
}
