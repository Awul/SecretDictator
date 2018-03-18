package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import static com.stalin.secretstalin.StartScreen.game;

public class RoundOverview extends AppCompatActivity {

    private TextView tvNumbersOfLiberalLaws;
    private TextView tvNumbersOfCommunistLaws;
    private Button submit;
    private Intent AwulHD;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_overview);
        submit = (Button) findViewById(R.id.submit);
        AwulHD = new Intent(getApplicationContext(), PresidentSelect.class);

        tvNumbersOfLiberalLaws.setText(game.getNumberOfAktiveLiberalLaws());
        tvNumbersOfCommunistLaws.setText(game.getNumberOfAktiveCommunistLaws());

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, game.personsList);
        mListView.setAdapter(adapter);

    }

    private void sumit(){
        game.nextPresidentIndex();
        startActivity(AwulHD);
    }
}
