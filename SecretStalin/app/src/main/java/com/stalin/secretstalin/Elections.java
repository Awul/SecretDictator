package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.stalin.secretstalin.StartScreen.game;

public class Elections extends AppCompatActivity {

    private int electionResult =0;
    private int playerCount =0;
    Intent selfTom;
    Intent notTom;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);
        selfTom = new Intent(getApplicationContext(),Elections.class);
        notTom = new Intent(getApplicationContext(), ElectionResult.class);
        notTom.putExtra("eValue",electionResult);
        //name = (TextView) findViewById(R.id.tvName);
        //name.setText(game.personsList.get(playerCount).getName());
    }
//TODO YES AND Nos
    public void voteYes(View v){

        electionResult++;
        playerCount++;
        if(playerCount<game.getPlayerCount()){
            startActivity(selfTom);
        }
        else{
            startActivity(notTom);
        }
    }

    public void voteNo(View v){
        electionResult--;
        playerCount++;
        if(playerCount<game.getPlayerCount()){
            startActivity(selfTom);
        }
        else{
            startActivity(notTom);
        }

    }



}
