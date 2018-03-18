package com.stalin.secretstalin;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.net.URISyntaxException;

public class LoadingGame extends AppCompatActivity {

    private boolean gameNotFinished=true;
    Intent next = null;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Setting the casual schmu
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //spawning the Layout like a boss:
        ConstraintLayout picLL=new ConstraintLayout(this);
        picLL.layout(0,0,100,100);

        setContentView(R.layout.activity_loading_game);
        findViewById(R.id.clicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(view);
            }
        });

        //getting Activity, that has to be started after this one:

        try {
            next = Intent.parseUri(getIntent().getStringExtra("next"), 0);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //Our Progress Bar
        ProgressBar prog = (ProgressBar) findViewById(R.id.loadingBar);

        while (gameNotFinished) {
            if(Math.random()*10<6){
                gameNotFinished=spawnDictator();
            }
        }

    }

    private boolean spawnDictator(){
       boolean hitted=false;

       return hitted;
    }

    public void click(View v){
        counter++;
        if (counter == 1) {
            counter = 0;
            startNext();
        }
    }

    private void startNext(){
        startActivity(next);
        finish();
    }
}
