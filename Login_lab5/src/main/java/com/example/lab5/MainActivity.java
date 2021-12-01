package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname,pwd;
    Button login,reg;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.uname);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        reg = findViewById(R.id.reg);
        db = new DbHandler(MainActivity.this);
        db.addUser(new User("Mahaan","mk123"));

        String name = uname.getText().toString();
        String pass = pwd.getText().toString();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = db.checkUser(new User(name,pass));
                if (id==-1){
                    Toast.makeText(getApplicationContext(), "User not found...", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Welcome "+name, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(i);
                }
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addUser(new User(name,pass));
                Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
            }
        });

    }
}