package com.example.msi.tabbedactivityorg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowItems extends AppCompatActivity {

    TextView  resNameTV;
    TextView  resDeptTV;
    TextView  resEmailTV;
    TextView  resPhoneTV;

    String names = "";
    String depts = "";
    String phones = "";
    String emails = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);

        resNameTV = (TextView)findViewById(R.id.resNameTV);
        resDeptTV = (TextView)findViewById(R.id.resDeptTV);
        resPhoneTV =(TextView) findViewById(R.id.resPhoneTV);
        resEmailTV =(TextView)findViewById(R.id.resEmailTV);

        Intent intent = getIntent();
        names = intent.getExtras().getString("name");
        depts = intent.getExtras().getString("dept");
        emails = intent.getExtras().getString("email");
        phones = intent.getExtras().getString("phone");

        resNameTV.setText(names);
        resDeptTV.setText(depts);
        resPhoneTV.setText(phones);
        resEmailTV.setText(emails);

    }
}
