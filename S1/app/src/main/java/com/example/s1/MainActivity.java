package com.example.s1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    ImageButton button; //TODO this 1
    Switch switch1;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        switch1=findViewById(R.id.switch1);
        cl=findViewById(R.id.cl);
    //TODO this 2
        DatePicker d = new DatePicker(this);
        cl.addView(d);
        button.setEnabled(false);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean enable) {
                if(enable){
                    button.setEnabled(true);
                }
                else {
                    button.setEnabled(false);
                }

            }
        });
    }

}