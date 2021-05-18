package com.saurav.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout name,contact,email;
    FloatingActionButton fb;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.nametext);
        contact=findViewById(R.id.contacttext);
        email=findViewById(R.id.emailtext);
        fb=findViewById(R.id.fbtn);
        submit=findViewById(R.id.sbmt_add);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataInsert(name.getEditText().getText().toString(),contact.getEditText().getText().toString(),email.getEditText().getText().toString());
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DisplayActivity.class));
            }
        });
    }

    private void dataInsert(String toString, String toString1, String toString2) {
        String result=new DbManager(this).addData(toString,toString1,toString2);
        name.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}