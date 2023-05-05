package com.rpgbattle;

import java.util.Scanner;

import com.rpgbattle.Character;

public class Fighter extends Character {

    public Fighter() {
        super(250, 250, 21, "Fighter");
    }

    public Fighter(int maxH, int currentH, int strength, String name) {
        super(maxH, currentH, strength, name);
    }

    @Override
    public String toString() {
        return String.format("\n%s: %d/%d HP max", getName(), getCurrentHP(), getMaxHP());
    }
}
   
 