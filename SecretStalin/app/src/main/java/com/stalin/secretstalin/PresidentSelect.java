package com.stalin.secretstalin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.stalin.secretstalin.StartScreen.game;

public class PresidentSelect extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_select);
        //name = (TextView) findViewById(R.id.tvName);
        //name.setText(game.personsList.get(game.getPresidentIndex()).getName());
    }

    //TODO Listview all Players but himself 8AWULHD9
}
