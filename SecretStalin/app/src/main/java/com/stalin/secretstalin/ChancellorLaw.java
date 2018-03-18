package com.stalin.secretstalin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.stalin.secretstalin.StartScreen.game;

public class ChancellorLaw extends AppCompatActivity{
    int card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chancellor_law);

        //TODO get selected Laws (extra 1 u 2)
    }

    //Select one Law
    //put it in kraft
    public void submit(){
        if (card==0){  //0=Communist
            game.setCommunistCount(game.getCommunistCount()-1);
        }
        else if(card==1){
            game.setLiberalCount(game.getLiberalCount()-1);
        }
    }
}
