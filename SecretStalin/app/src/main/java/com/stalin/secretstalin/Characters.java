package com.stalin.secretstalin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.stalin.secretstalin.StartScreen.game;

public class Characters extends AppCompatActivity {
    private Button submit;
    private EditText name;
    private int[] role;
    private Intent tom;
    private Intent startSelf;
    private Intent startNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_characters);
        submit = (Button) findViewById(R.id.submit);
        role = new int[game.getPlayerCount()];
        setRoles();
        ((TextView) findViewById(R.id.tvrole)).setText("You are a " + this.getRole(role[game.personsList.size()]));
        tom = new Intent(getApplicationContext(),LoadingGame.class);
        startSelf = new Intent(getApplicationContext(), Characters.class);
        startNext= new Intent(getApplicationContext(), Instructions.class);
    }

    public void getName(View v) {
        name = (EditText) findViewById(R.id.nameField);

        System.out.println("Index " + game.personsList.size() + " " + name.getText().toString());
        game.personsList.add(new Person(name.getText().toString(), role[game.personsList.size()], false, false, false));

        if(game.personsList.size()<game.getPlayerCount()){
            String s = startSelf.toUri(0);
            tom.putExtra("next", s);
            startActivity(tom);
        }else{
            startActivity(startNext);
        }
    }

    private void setRoles() {

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

    private String getRole(int i) {
        switch (i) {
            case 0:
                return "Stalin";
            case 1:
                return "Communist";
            case 2:
                return "Liberal";
        }
        return "";
    }







}
