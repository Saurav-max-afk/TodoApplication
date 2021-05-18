package com.saurav.todoapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Modal> dataholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=new DbManager(this).readalldata();
        dataholder=new ArrayList<>();

        while (cursor.moveToNext()){
            Modal obj=new Modal(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            dataholder.add(obj);
        }

         Adapter adapter=new Adapter(dataholder);
         recyclerView.setAdapter(adapter);


    }
}