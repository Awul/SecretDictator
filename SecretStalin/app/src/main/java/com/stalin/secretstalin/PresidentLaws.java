package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import static com.stalin.secretstalin.StartScreen.game;

public class PresidentLaws extends AppCompatActivity {

    private ArrayList<Integer> tom;  //Syntax u instanziierung
    private Intent tomReich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_laws);
        tomReich = new Intent(getApplicationContext(), ChancellorLaw.class);
        tom = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            tom.add(game.getLaw());
        }
    }
    //3 ToggleButtons
    //1 Submitbutton
    //TODO GUI und alles amdere eigentlich auch #tom *top
    public void submit(){
        //if 2 selected
            tomReich.putExtra("1",1);//Gesetz Gewähltes);
            tomReich.putExtra("2",1);//Gestz Gewähltes);
    }
}
