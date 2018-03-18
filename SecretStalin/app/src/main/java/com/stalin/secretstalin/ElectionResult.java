package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.stalin.secretstalin.StartScreen.game;

public class ElectionResult extends AppCompatActivity {

    private int electionResult;
    Intent backTom;
    Intent topTom;
    Intent preTopTom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_result);
        backTom = new Intent(getApplicationContext(), PresidentSelect.class);
        topTom = new Intent(getApplicationContext(), PresidentLaws.class);
        preTopTom = new Intent(getApplicationContext(), LoadingGame.class);
        //TODO ERST LOADING MIT EXTRA WEITERLEITUARFHUSAjn
    }

    private void result(){
        if(electionResult>0){
            game.failCounter=0;
            startActivity(topTom);
            //win
        }
        else{
            game.failCounter++;
            if(game.failCounter>3){
                //ElectionFail
            }
            game.nextPresidentIndex();
            startActivity(backTom);
            //lose
        }
    }
}
