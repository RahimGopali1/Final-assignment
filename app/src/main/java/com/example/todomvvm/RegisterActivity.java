package com.example.todomvvm;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    com.example.todomvvm.Database DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signin = (Button) findViewById(R.id.btnsigin);
        signup = (Button) findViewById(R.id.btnsignup);
        DB = new com.example.todomvvm.Database(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(com.example.todomvvm.RegisterActivity.this, "Please enter all the feilds", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(com.example.todomvvm.RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), com.example.todomvvm.LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(com.example.todomvvm.RegisterActivity.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(com.example.todomvvm.RegisterActivity.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(com.example.todomvvm.RegisterActivity.this, "Password Not Matching!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), com.example.todomvvm.LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    protected void onStart(){
        super.onStart();
        Log.i("testlifecycle", "on create event" );
    }

    protected void onResume(){
        super.onResume();
        Log.i("testlifecycle", "on resume event" );
    }

    protected void onPause(){
        super.onPause();
        Log.i("testlifecycle", "on pause event" );
    }

    protected void onStop(){
        super.onStop();
        Log.i("testlifecycle", "on stop event" );
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i("testlifecycle", "on destroy event" );
    }
}