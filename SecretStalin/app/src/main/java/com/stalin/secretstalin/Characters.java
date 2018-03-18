package com.stalin.secretstalin;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import static com.stalin.secretstalin.StartScreen.game;

public class Characters extends AppCompatActivity {
    private Button submit;
    private EditText name;
    private int[] role;
    private int awul = 0;
    private Intent tom;
    private Intent tomSelf;
    private Intent awulSelf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        submit = (Button) findViewById(R.id.submit);
        role = new int[game.getPlayerCount()];
        setRoles();
        tom = new Intent(getApplicationContext(),LoadingGame.class);
        tomSelf = new Intent(getApplicationContext(), Characters.class);
        //awulSelf= new Intent(getApplicationContext(), InstructionSchlief.class);
    }

    public void getName(View v){
        name = (EditText) findViewById(R.id.nameField);

        game.personsList.add(new Person(name.getText().toString(),role[awul], false, false, false));
        awul++;
        if(awul<game.getPlayerCount()){
            String s = tomSelf.toUri(0);
            tom.putExtra("next", s);
            startActivity(tom);
        }else{
            startActivity(awulSelf);
        }
    }


    private void setRoles(){

        List<Integer> roleHelpArray;
        roleHelpArray = new ArrayList<Integer>();

        for (int i = 0; i < game.getCommunistCount(); i++){
            roleHelpArray.add(1);
        }

        for (int i = 0; i < game.getLiberalCount(); i++){

            roleHelpArray.add(2);
        }

        roleHelpArray.add(0);

        for (int i = 0; i < game.getPlayerCount(); i++){

            int tempInt = (int)Math.random()*(roleHelpArray.size()-1);

            role[i] = roleHelpArray.get(tempInt);

            roleHelpArray.remove(tempInt);

        }

    }








}
