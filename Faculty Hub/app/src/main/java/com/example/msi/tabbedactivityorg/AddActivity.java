package com.example.msi.tabbedactivityorg;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button addBtn;
    Button seeBtn;
    EditText nameTV;
    EditText depTV;
    EditText phoneTV;
    EditText mailTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        nameTV = (EditText) findViewById(R.id.nameTV);
        depTV = (EditText) findViewById(R.id.depTV);
        phoneTV = (EditText) findViewById(R.id.phoneTV);
        mailTV = (EditText) findViewById(R.id.mailTV);

        addBtn = (Button) findViewById(R.id.addBtn);
        seeBtn = (Button) findViewById(R.id.seeBtn);
        myDB = new DatabaseHelper(this);

        seeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this,Tab2Fragment.class);
                startActivity(intent);

            }
        });

        AddData();

    }
    public  void AddData() {

        addBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {




                        if(nameTV.getText().length() == 0 || mailTV.getText().length() == 0 ||phoneTV.getText().length() == 0 ||mailTV.getText().length() == 0)
                        {
                            Toast.makeText(AddActivity.this, "Please Check again!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            boolean isInserted = myDB.insertData(nameTV.getText().toString(),
                                    depTV.getText().toString(),
                                    phoneTV.getText().toString(), mailTV.getText().toString());
                            if (isInserted == true) {
                                nameTV.setText("");
                                mailTV.setText("");
                                depTV.setText("");
                                phoneTV.setText("");
                                Toast.makeText(AddActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(AddActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                            }

                        }
                    }
                }


        );


    }


}
