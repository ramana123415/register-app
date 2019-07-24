package com.example.a135;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String TAG = "MyActivity";


    public static MainActivity Instance;

    //Declaration
    Button btnStart;
    EditText first, last, email, password;
    SharedPreferences sharedPreferences;
    String myFirst, myLast, myEmail,myPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //Initilization of sharedPreferences
        sharedPreferences = getApplicationContext().getSharedPreferences("Ram", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        //if the user previously loggedin its goes to next screen
        boolean login = (sharedPreferences.getBoolean("is_register", false));
        if (login == true) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        btnStart = (Button) findViewById(R.id.btn_register);
        first = (EditText) findViewById(R.id.et_first);
        last = (EditText) findViewById(R.id.et_last);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myFirst = first.getText().toString();
                myLast=last.getText().toString();
                myEmail=email.getText().toString();
                myPassword = password.getText().toString();

                //Inserting data in sharedpreference
                editor.putString("key_first", myFirst);
                editor.putString("key_last", myLast);
                editor.putString("key_email", myEmail);
                editor.putString("key_password", myPassword);
                editor.putBoolean("is_register", true);
                //save entered data
                editor.commit();


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });
        Log.e(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");

    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }
}

