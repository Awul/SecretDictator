package com.schmu.secretdictator;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Characters extends AppCompatActivity {
    private Button submit;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        submit = (Button) findViewById(R.id.submit);
    }

    public void getName(View v){
        name = (EditText) findViewById(R.id.nameField);
    }








}
