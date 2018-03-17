package com.schmu.secretdictator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.net.URISyntaxException;

public class LoadingGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Setting the casual schmu
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading_game);

        //getting Activity, that has to be started after this one:
        try {
            Intent next=Intent.parseUri(getIntent().getStringExtra("next"),0);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        for(int i=0;i<100;i++){

        }

    }
}
