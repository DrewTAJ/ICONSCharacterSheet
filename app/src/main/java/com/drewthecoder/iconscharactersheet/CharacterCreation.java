package com.drewthecoder.iconscharactersheet;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import java.text.AttributedCharacterIterator;
import java.util.HashSet;
import java.util.Set;

public class CharacterCreation extends AppCompatActivity implements View.OnClickListener {

    EditText nameInput;
    EditText healthInput;
    EditText staminaInput;

    EditText prowessInput;
    EditText coordinationInput;
    EditText strengthInput;
    EditText intellectInput;
    EditText awarenessInput;
    EditText willpowerInput;

    Button addPower;
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

        this.nameInput = (EditText) findViewById(R.id.name_input);
        this.healthInput = (EditText) findViewById(R.id.health_input);
        this.staminaInput = (EditText) findViewById(R.id.stamina_input);

        this.addPower = (Button) findViewById(R.id.add_powers_button);
        this.addSpecialty = (Button) findViewById(R.id.add_specialties_button);
        this.addAspect = (Button) findViewById(R.id.add_aspects_button);
        this.addNote = (Button) findViewById(R.id.add_notes_button);
        this.addQuality = (Button) findViewById(R.id.add_qualities_button);
        this.addChallenge = (Button) findViewById(R.id.add_challenges_button);

        this.prowessInput = (EditText) findViewById(R.id.prowess_input);
        this.coordinationInput = (EditText) findViewById(R.id.coordination_input);
        this.strengthInput = (EditText) findViewById(R.id.strength_input);
        this.intellectInput = (EditText) findViewById(R.id.intellect_input);
        this.awarenessInput = (EditText) findViewById(R.id.awareness_input);
        this.willpowerInput = (EditText) findViewById(R.id.willpower_input);

        this.addNote.setOnClickListener(this);
        this.addQuality.setOnClickListener(this);
        this.addChallenge.setOnClickListener(this);
    }

    // Menu icons are inflated just as they were with actionbar
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.add_notes_button: {
                // do something for button 1 click
                this.addInput(R.id.notes_container, R.string.note_placeholder);
                break;
            }

            case R.id.add_qualities_button: {
                // do something for button 2 click
                this.addInput(R.id.qualities_container, R.string.quality_placeholder);
                break;
            }

            case R.id.add_challenges_button: {
                this.addInput(R.id.challenges_container, R.string.challenge_placeholder);
                break;
            }

            case R.id.add_specialties_button: {
                this.addInput(R.id.specialties_container, R.string.specialty_placeholder);
                break;
            }

            case R.id.add_powers_button: {
                this.addPower();
            }

            //.... etc
        }
    }

    public void addPower() {
        LinearLayout powersContainer = (LinearLayout) findViewById(R.id.powers_container);
        LinearLayout powerContainer = new LinearLayout(this);
        powerContainer.setOrientation(LinearLayout.HORIZONTAL);
        EditText powerNameInput = new EditText(this);
        powerNameInput.setHint(R.string.power_name_placeholder);
        EditText powerValueInput = new EditText(this);
        powerValueInput.setHint(R.string.power_value_placeholder);
        powerContainer.addView(powerNameInput);
        powerContainer.addView(powerValueInput);
    }

    public void addInput(int id, int placeholder) {
        if(id != 0) {
            LinearLayout inputContiner = (LinearLayout) findViewById(id);
            EditText input = new EditText(this);
            input.setHint(placeholder);
            inputContiner.addView(input, inputContiner.getChildCount() - 1);
        }
    }

    public void saveCharacter() {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("name", this.nameInput.getText().toString());
        editor.putInt("health", Integer.parseInt(this.healthInput.getText().toString()));
        editor.putInt("stamina", Integer.parseInt(this.staminaInput.getText().toString()));
        editor.putInt("prowess", Integer.parseInt(this.prowessInput.getText().toString()));
        editor.putInt("coordination", Integer.parseInt(this.coordinationInput.getText().toString()));
        editor.putInt("strength", Integer.parseInt(this.strengthInput.getText().toString()));
        editor.putInt("intellect", Integer.parseInt(this.intellectInput.getText().toString()));
        editor.putInt("awareness", Integer.parseInt(this.awarenessInput.getText().toString()));
        editor.putInt("willpower", Integer.parseInt(this.willpowerInput.getText().toString()));
        Set<String> notes = getListViewValues(R.id.notes_container);
        Set<String> qualities = getListViewValues(R.id.qualities_container);
        Set<String> challenges = getListViewValues(R.id.challenges_container);
        Set<String> specialties = getListViewValues(R.id.specialties_container);


        LinearLayout powersContainer = (LinearLayout) findViewById(R.id.powers_container);
        for(int i = 0; i < powersContainer.getChildCount(); i++) {
            LinearLayout powerInputContainer = (LinearLayout) powersContainer.getChildAt(i);
            EditText powerNameInput = (EditText) powerInputContainer.getChildAt(0);
            EditText powerValueInput = (EditText) powerInputContainer.getChildAt(1);
            editor.putString("power_" + i + "_name", powerNameInput.getText().toString());
            editor.putInt("power_" + i + "_input", Integer.parseInt(powerValueInput.getText().toString()));
        }
        editor.putStringSet("notes", notes);
        editor.putStringSet("challenges", challenges);
        editor.putStringSet("qualities", qualities);
        editor.putStringSet("specialties", specialties);
        editor.apply();
    }

    private Set<String> getListViewValues(int id) {
        Set<String> values = new HashSet<String>();
        LinearLayout inputContainer = (LinearLayout) findViewById(id);
        for(int i=0; i < inputContainer.getChildCount(); i++) {
            EditText child = (EditText) inputContainer.getChildAt(i);
            values.add(child.getText().toString());
        }
        return values;
    }

    public void addQuality() {

    }

}
