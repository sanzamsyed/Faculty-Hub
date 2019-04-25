package com.example.msi.tabbedactivityorg;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/28/2017.
 */

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";
    DatabaseHelper myDB;
    String name = "";
    String phone = "";
    String email = "";
    String dept = "";
    Cursor data;


    ///ListView listView;
    Information im;
    CustomAdapter customAdapter;
    ArrayList<Information> arrayList = new ArrayList<>();
    DatabaseHelper db;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        myDB = new DatabaseHelper(getActivity());
        ArrayList<String> theList = new ArrayList<>();
        db = new DatabaseHelper(getActivity());
        arrayList = db.getAllData();
        customAdapter = new CustomAdapter(getActivity(), arrayList);




        data = myDB.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(getActivity(), "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(getActivity(), R.layout.customtextlist, theList);
                listView.setAdapter(listAdapter);

            }

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    im = customAdapter.getItem(i);
                    Intent intent = new Intent(getActivity(), Main2Activity.class);
                    intent.putExtra("name", im.getName());
                    intent.putExtra("dept", im.getDept());
                    intent.putExtra("phone", im.getPhone());
                    intent.putExtra("email", im.getEmail());


                    startActivity(intent);



                }
            });


        }






        return view;


    }



}

