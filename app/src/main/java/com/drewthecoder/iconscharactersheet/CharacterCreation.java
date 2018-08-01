package com.drewthecoder.iconscharactersheet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

public class CharacterCreation extends AppCompatActivity {

    EditText nameInput;
    NumberPicker healthInput;
    NumberPicker staminaInput;

    NumberPicker strengthInput;
    NumberPicker intellectInput;
    NumberPicker prowessInput;
    NumberPicker coordinationInput;
    NumberPicker awarenessInput;
    NumberPicker willpowerInput;


    Button addSpecialty;
    Button addNote;
    Button addAspect;
    Button addQuality;
    Button addChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
