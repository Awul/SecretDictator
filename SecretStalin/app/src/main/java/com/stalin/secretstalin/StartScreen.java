package com.stalin.secretstalin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    public static Game game;
    private TextView tvPlayers;
    private TextView tvCommunists;
    private TextView tvLiberals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowMan
                ager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_screen);
        SeekBar Players = (SeekBar) findViewById(R.id.seekBar);
        Players.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                playerChange(i+5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        game = new Game(5,1,1,3);
        tvPlayers = (TextView) findViewById(R.id.tvPlayerCount);
        tvCommunists = (TextView) findViewById(R.id.tvCommunist);
        tvLiberals = (TextView) findViewById(R.id.tvLiberal);
    }

    private void playerChange(int i){
        game.setPlayerCount(i);
        tvPlayers.setText("Players: "+ game.getPlayerCount());
        playerDistribution(i);
    }

    private void playerDistribution(int i){
        switch(i){
            case 5:
                game.setCommunistCount(1);
                game.setLiberalCount(3);
                break;
            case 6:
                game.setCommunistCount(1);
                game.setLiberalCount(4);
                break;
            case 7:
                game.setCommunistCount(2);
                game.setLiberalCount(4);
                break;
            case 8:
                game.setCommunistCount(2);
                game.setLiberalCount(5);
                break;
            case 9:
                game.setCommunistCount(3);
                game.setLiberalCount(5);
                break;
            case 10:
                game.setCommunistCount(3);
                game.setLiberalCount(5);
                break;

        }

        tvLiberals.setText("Liberals: "+ game.getLiberalCount());
        tvCommunists.setText("Communists: "+game.getCommunistCount());
    }

    public void nuke(View v) {
        Intent lock = new Intent(getApplicationContext(), LoadingGame.class);
        Intent names = new Intent(getApplicationContext(), Characters.class);
        lock.putExtra("next", names.toUri(0));
        startActivity(lock);
    }

}
