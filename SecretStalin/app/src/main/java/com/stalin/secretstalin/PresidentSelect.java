package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

import static com.stalin.secretstalin.StartScreen.game;

public class PresidentSelect extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_select);
        ArrayList<String> names = new ArrayList<String>();
        ((TextView) findViewById(R.id.tvPresName)).setText(game.personsList.get(game.getPresidentIndex()).getName() + ", nominate a chancellor");
        for (Person p : game.personsList) {
            names.add(p.getName());
        }
        ListView list = (ListView) findViewById(R.id.playersList);
        list.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.player, names));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent kanzlerWahl = new Intent(getApplicationContext(), Elections.class);
                kanzlerWahl.putExtra("kanzler", i);
                startActivity(kanzlerWahl);
                finish();
            }
        });
    }
    // TODO: Cooldown
}
