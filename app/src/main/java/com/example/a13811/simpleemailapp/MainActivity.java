package com.example.a13811.simpleemailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText subject,email,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=(EditText)findViewById(R.id.email);
        subject=(EditText)findViewById(R.id.subject);
        message=(EditText)findViewById(R.id.message);
        send=(Button)findViewById(R.id.sned);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=email.getText().toString();
                String subjecta=subject.getText().toString();
                String mess=message.getText().toString();

                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT,subjecta);
                intent.putExtra(Intent.EXTRA_TEXT,mess);

                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Select Email app"));


            }
        });

    }
}
