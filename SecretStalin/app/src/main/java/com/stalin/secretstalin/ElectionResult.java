package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import static com.stalin.secretstalin.StartScreen.game;

public class ElectionResult extends AppCompatActivity {

    private int electionResult;
    Intent backTom;
    Intent topTom;
    Intent preTopTom;
    int vorschlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_election_result);
        backTom = new Intent(getApplicationContext(), PresidentSelect.class);
        topTom = new Intent(getApplicationContext(), PresidentLaws.class);
        preTopTom = new Intent(getApplicationContext(), LoadingGame.class);
        int yes = getIntent().getIntExtra("votesYes", 0);
        int no = getIntent().getIntExtra("votesNo",0);
        vorschlag = getIntent().getIntExtra("kandidat",0);
        electionResult = yes-no;
        ((TextView)findViewById(R.id.tvYes)).setText("Yes: "+yes);
        ((TextView)findViewById(R.id.tvNo)).setText("No: "+no);
        ((TextView)findViewById(R.id.textView4)).setText(game.personsList.get(vorschlag).getName());


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
