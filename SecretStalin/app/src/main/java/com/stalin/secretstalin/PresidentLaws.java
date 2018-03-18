package com.stalin.secretstalin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.stalin.secretstalin.StartScreen.game;

public class PresidentLaws extends AppCompatActivity {

    private ArrayList<Integer> policy;
    private Intent tomReich;
    private ToggleButton togglebutton;
    private int selectionCount;
    private Button submit;
    private ArrayList<ToggleButton> buttonArray = new ArrayList<>();
    private ArrayList<Integer> nextPolicys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president_laws);
        tomReich = new Intent(getApplicationContext(), ChancellorLaw.class);
        policy = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            policy.add(game.getLaw());
        }
        submit = (Button) findViewById(R.id.submitButton);
        submit.setEnabled(false);

        ToggleButton toggleOne = (ToggleButton) findViewById(R.id.toggleButtonOne);
        buttonArray.add(toggleOne);
        ToggleButton toggleTwo = (ToggleButton) findViewById(R.id.toggleButtonTwo);
        buttonArray.add(toggleTwo);
        ToggleButton toggleThree = (ToggleButton) findViewById(R.id.toggleButton);
        buttonArray.add(toggleThree);


        for (int i = 0; i < buttonArray.size(); i++){

            if (policy.get(i) == 1){
                buttonArray.get(i).setText("Liberal");
            }else{
                buttonArray.get(i).setText("Communist");
            }
        }
        togglebutton(toggleOne);
        togglebutton(toggleTwo);
        togglebutton(toggleThree);

    }

    private void togglebutton(final ToggleButton toggle) {

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    selectionCount++;

                    if (selectionCount == 2){
                        policy.get(checkButtoninArray(toggle));
                        submit.setEnabled(true);
                    }else{
                        policy.get(checkButtoninArray(toggle));
                        submit.setEnabled(false);
                    }
                } else {
                    selectionCount--;
                }
            }
        });
    }

    private int checkButtoninArray(ToggleButton button){
        for (int i = 0; i < buttonArray.size(); i++) {
            if (button == buttonArray.get(i)) {
                return i;
            }
        }
        return -1;
    }

    //3 ToggleButtons
    //1 Submitbutton
    //TODO GUI und alles amdere eigentlich auch #tom *top
    public void submit(){
        //if 2 selected
            tomReich.putExtra("1",1);//Gesetz Gewähltes);
            tomReich.putExtra("2",1);//Gestz Gewähltes);
    }
}
