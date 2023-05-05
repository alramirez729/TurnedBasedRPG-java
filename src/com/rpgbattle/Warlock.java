package com.rpgbattle;

import java.util.Scanner;

import com.rpgbattle.Character;
import com.rpgbattle.DamageCaster;

public class Warlock extends Character implements DamageCaster {
    private int currentMP;
    private int maxMP;
    private int intelligence;

    public Warlock() {
        super(250, 250, 9, "Warlock");
        maxMP = 100;
        currentMP = 100;
        intelligence = 33;
    }

    public Warlock(int maxH, int currentH, int maxM, int currentM, int strength, int intel, String name) {
        super(maxH, currentH, strength, name);
        maxMP = (maxH < 20) ? 20 : maxM;
        currentMP = Math.max(currentM, 0);
        intelligence = Math.max(intel, 1);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    @Override
    public void thunder(Character[] enemies) {
        if (getCurrentMP() >= 20) {
            System.out.printf("\n%s casts Thunder on all enemies!", getName());
            setCurrentMP(getCurrentMP() - 20);
            for (Character currentEnemy : enemies) {
                int thunder = (20 - (this.random.nextInt(4))) * getIntelligence();
                currentEnemy.setCurrentHP(currentEnemy.getCurrentHP() - thunder);
                System.out.printf("%s", currentEnemy);
            }
        } else {
            System.out.printf("\n%s needs 20 MP to cast Thunder!", getName());
        }
    }

    @Override
    public String toString() {
        return String.format("\n%s: %s, %d/%d MP max", getName(), super.toString(), getCurrentMP(), getMaxMP());
    }
}
