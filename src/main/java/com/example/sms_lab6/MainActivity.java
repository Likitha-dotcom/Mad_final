package com.example.sms_lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText phno,msg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phno=findViewById(R.id.phno);
        msg=findViewById(R.id.msg);
        send=findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(phno.getText().toString(),null,msg.getText().toString(),null,null);
                    Toast.makeText(getApplicationContext(), "SMS sent successfully", Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Failed to send SMS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}