package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import static com.stalin.secretstalin.StartScreen.game;

public class Elections extends AppCompatActivity {

    Person vorschlag;
    private static int yes = 0;
    private static int no = 0;
    private static int playerCount = 0;
    Intent startSelf;
    Intent next;
    int vorschlagIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        vorschlagIndex = getIntent().getIntExtra("kanzler", 0);
        vorschlag = game.personsList.get(vorschlagIndex);
        setContentView(R.layout.activity_elections);
        startSelf = new Intent(getApplicationContext(),Elections.class);
        startSelf.putExtra("kanzler", vorschlagIndex);
        ((TextView) findViewById(R.id.tvName)).setText(vorschlag.getName());

    }
    //TODO YES AND Nos
    public void voteYes(View v){

        yes++;
        playerCount++;
        if(playerCount<game.getPlayerCount()){
            startActivity(startSelf);
        }
        else{
            next = new Intent(getApplicationContext(), ElectionResult.class);
            next.putExtra("votesYes",yes);
            next.putExtra("votesNo",no);
            next.putExtra("kandidat", vorschlagIndex);
            startActivity(next);
            finish();
        }
    }

    public void voteNo(View v){
        no++;
        playerCount++;
        if(playerCount<game.getPlayerCount()){
            startActivity(startSelf);
            finish();
        }
        else{
            next = new Intent(getApplicationContext(), ElectionResult.class);
            next.putExtra("votesYes",yes);
            next.putExtra("votesNo",no);
            next.putExtra("kandidat", vorschlagIndex);
            startActivity(next);
            finish();
        }

    }



}
