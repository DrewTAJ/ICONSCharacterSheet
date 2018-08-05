package com.drewthecoder.iconscharactersheet;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView name;
    TextView stamina;
    TextView maximumHealth;
    TextView determination;
    TextView weight;
    TextView height;

    TextView prowess;
    TextView coordination;
    TextView strength;
    TextView intellect;
    TextView awareness;
    TextView willpower;

    String[] notes;
    String[] specialties;
    String[] qualities;
    String[] challenges;
    Ability[] abilities;
    Ability[] powers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Intent intent = new Intent(this, CharacterCreation.class);
        startActivity(intent);

        this.name = (TextView) findViewById(R.id.name);
        this.stamina = (TextView) findViewById(R.id.stamina);
        this.maximumHealth = (TextView) findViewById(R.id.maximumHealth);
        this.determination = (TextView) findViewById(R.id.determination);
        this.height = (TextView) findViewById(R.id.height);
        this.weight = (TextView) findViewById(R.id.weight);

        this.prowess = (TextView) findViewById(R.id.prowess_input);
        this.coordination = (TextView) findViewById(R.id.coordination);
        this.strength = (TextView) findViewById(R.id.strength);
        this.intellect = (TextView) findViewById(R.id.intellect);
        this.awareness = (TextView) findViewById(R.id.awareness);
        this.willpower = (TextView) findViewById(R.id.willpower);

        name.setText("STUFF");
        stamina.setText(Integer.toString(11));
        maximumHealth.setText(Integer.toString(11));
        determination.setText(Integer.toString(4));
        height.setText("6.6");
        weight.setText("170");

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        this.name.setText(prefs.getString("name", ""));
        this.stamina.setText(prefs.getInt("stamina", 0));
        this.maximumHealth.setText(prefs.getInt("health", 0));
        this.determination.setText(prefs.getInt("determination", 0));

        this.prowess.setText(prefs.getInt("prowess", 0));
        this.coordination.setText(prefs.getInt("coordination", 0));
        this.strength.setText(prefs.getInt("strength", 0));
        this.intellect.setText(prefs.getInt("intellect", 0));
        this.awareness.setText(prefs.getInt("awareness", 0));
        this.willpower.setText(prefs.getInt("willpower", 0));

        this.populateSection(R.id.notes_container, prefs.getStringSet("notes", new HashSet<String>()));
        this.populateSection(R.id.specialties_container, prefs.getStringSet("specialties", new HashSet<String>()));
        this.populateSection(R.id.qualities_container, prefs.getStringSet("qualities", new HashSet<String>()));
        this.populateSection(R.id.challenges_container, prefs.getStringSet("challenges", new HashSet<String>()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void populateSection(int id, Set<String> notes) {
        if(notes != null) {
            LinearLayout root = (LinearLayout) findViewById(id);
            for (String note : notes) {
                TextView textView = new TextView(this);
                textView.setText(note);
                root.addView(textView);
            }
        }
    }

    public void populateAbilities(Ability[] items) {
        if(items != null) {
            for(Ability item: items) {

            }
        }
    }
}
