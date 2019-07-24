package com.example.a135;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{
    SharedPreferences sharedPreferences;
    TextView first , last, email,password;
    //Commit test
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        first= (TextView)findViewById(R.id.tv_first);
        last= (TextView)findViewById(R.id.tv_last);
        email= (TextView)findViewById(R.id.tv_email);
        password=(TextView)findViewById(R.id.tv_password);

        //Installation Method
        sharedPreferences =  getApplicationContext().getSharedPreferences("Ram", MODE_PRIVATE);

        first.setText(sharedPreferences.getString("key_first",null));
        last.setText(sharedPreferences.getString("key_last",null));
        email.setText(sharedPreferences.getString("key_email",null));
        password.setText(sharedPreferences.getString("key_password",null));






    }
}
