package com.drewthecoder.iconscharactersheet;
import com.drewthecoder.iconscharactersheet.Ability;

/**
 * Created by Drew on 2018-07-07.
 */

public class Character {

    public Ability[] abilities;
    public String[] challenges;
    public int determination;
    public String firstAppearance;
    public int health;
    public int height;
    public String name;
    public String[] notes;
    public Ability[] powers;
    public String[] qualities;
    public String[] specialites;
    public int stamina;
    public int weight;

    public Character(int health) {
        this.health = health;
    }
}
