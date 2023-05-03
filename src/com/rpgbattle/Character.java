package com.rpgbattle;

import java.util.Random;

public abstract class Character {
    protected final Random random;
    private int maxHP;
    private int currentHP;
    private int strength;
    private String name;

    public Character(int maxH, int currentH, int strength, String name) {
        maxHP = Math.max(maxH, 1);
        currentHP = Math.max(currentH, 1);
        this.strength = Math.max(strength, 1);
        this.name = name;
        random = new Random();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int max) {
        maxHP = max;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int current) {
        currentHP = (current < 1) ? 0 : current;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public abstract void attack(Character d);

    public boolean isDead() {
        return getCurrentHP() == 0;
    }

    public String toString() {
        return String.format("%d/%d HP max", getCurrentHP(), getMaxHP());
    }

    public abstract void move(Character[] allies, Character[] enemies);
}
