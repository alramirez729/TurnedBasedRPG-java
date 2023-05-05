package com.rpgbattle;

import java.util.Scanner;

import com.rpgbattle.Character;
import com.rpgbattle.HealCaster;

public class Cleric extends Character implements HealCaster {
    private int currentMP;
    private int maxMP;
    private int intelligence;

    public Cleric() {
        super(250, 250, 9, "Cleric");
        maxMP = 100;
        currentMP = 100;
        intelligence = 33;

    }

    public Cleric(int maxH, int currentH, int maxM, int currentM, int strength, int intel, String name) {
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
    public void heal(com.rpgbattle.Character[] allies) {
        if (getCurrentMP() >= 20) {
            System.out.printf("\n%s casts Heal on all allies!", getName());
            setCurrentMP(getCurrentMP() - 20);
            for (Character currentAlly : allies) {
                if (currentAlly.getCurrentHP() != 0) {
                    int heal = (20 - (this.random.nextInt(4))) * getIntelligence();
                    int FixedHeal = (heal + currentAlly.getCurrentHP() >= currentAlly.getMaxHP()) ? currentAlly.getMaxHP() : heal;
                    currentAlly.setCurrentHP(FixedHeal);
                    System.out.printf("%s", currentAlly);
                } else {
                    System.out.printf("\n%s is dead and cannot be healed.", getName());
                }
            }
        } else {
            System.out.printf("\n%s needs 20 MP to cast Heal!", getName());
        }
        System.out.println();
    }

    @Override
    public void attack(Character d) {
        int hit;
        hit = (10 - (this.random.nextInt(4))) * getStrength();
        d.setCurrentHP(d.getCurrentHP() - hit);
        System.out.printf("\n%s attacks %s for %d damage! %s", getName(), getName(), hit, d);
    }

    @Override
    public String toString() {
        return String.format("\n%s: %s, %d/%d MP max", getName(), super.toString(), getCurrentMP(), getMaxMP());

    }

    @Override
    public void move(Character[] allies, Character[] enemies) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n1. Fight");
        System.out.println("2. Heal");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> { // Fight
                System.out.print("\n\nHere are the enemies to fight:");
                for (int i = 0; i < enemies.length; i++)
                    if (enemies[i].getCurrentHP() > 0)
                        System.out.printf("%s (Enter %d to attack)", enemies[i].toString(), i + 1);
                    else
                        System.out.printf("%s (DEAD)", enemies[i].toString());
                System.out.print("\nWhich one do you want to fight?");
                int en = input.nextInt() - 1;
                attack(enemies[en]);
            }
            case 2 -> heal(allies);
        } // end switch
    }
} // end class
