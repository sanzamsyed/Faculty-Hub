package com.example.msi.tabbedactivityorg;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView firstTV;
    TextView secondTV;
    TextView thirdTV;
    TextView fourthTV;
    Button callBtn;
    Button textBtn;
    Button mailBtn;

    String names = "";
    String depts = "";
    String phones = "";
    String emails = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "folder/font6.ttf");
        Typeface custom_font2 = Typeface.createFromAsset(getAssets(), "folder/fontxx.ttf");
        Typeface custom_font3 = Typeface.createFromAsset(getAssets(), "folder/fontfinal.ttf");


        firstTV = (TextView) findViewById(R.id.firstTV);
        secondTV = (TextView) findViewById(R.id.secondTV);
        thirdTV = (TextView) findViewById(R.id.thirdTV);
        fourthTV = (TextView) findViewById(R.id.fourthTV);

        callBtn = (Button) findViewById(R.id.callBtn);
        textBtn = (Button) findViewById(R.id.textBtn);
        mailBtn = (Button) findViewById(R.id.mailBtn);


        callBtn.setTypeface(custom_font3);
        mailBtn.setTypeface(custom_font3);
        textBtn.setTypeface(custom_font3);

        Intent intent = getIntent();
        names = intent.getExtras().getString("name");
        depts = intent.getExtras().getString("dept");
        emails = intent.getExtras().getString("email");
        phones = intent.getExtras().getString("phone");

        firstTV.setText(names);
        firstTV.setTypeface(custom_font);

        secondTV.setText(depts);
        secondTV.setTypeface(custom_font2);
        thirdTV.setText(phones);
        thirdTV.setTypeface(custom_font2);
        fourthTV.setText(emails);
        fourthTV.setTypeface(custom_font2);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = thirdTV.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL);
                String p = "tel:" + number;
                i.setData(Uri.parse(p));
                startActivity(i);

            }
        });


        textBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = thirdTV.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number));
                intent.putExtra("sms_body", "");
                startActivity(intent);
            }
        });



        mailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });


    }


    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {fourthTV.getText().toString()};
        String[] CC = {"sanzamsyed71@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {

            Toast.makeText(this, "No Email Client Installed!", Toast.LENGTH_SHORT).show();
        }
    }

}


