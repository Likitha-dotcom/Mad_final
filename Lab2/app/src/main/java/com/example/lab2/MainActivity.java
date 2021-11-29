package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ImageButton b1;
    Switch s1;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.b1);
        s1=findViewById(R.id.s1);
        cl=findViewById(R.id.cl);
        b1.setEnabled(false);

        DatePicker d = new DatePicker(this);
        cl.addView(d);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    b1.setEnabled(true);
                }
                else {
                    b1.setEnabled(false);
                }
            }
        });
    }
}