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

    public void move(Character[] allies, Character[] enemies) {
        String[] options = new String[3];
        options[0] = "Attack";
        if (this instanceof com.rpgbattle.HealCaster && this instanceof com.rpgbattle.DamageCaster) {
            options[1] = "Heal";
            options[2] = "Thunder";
        } else if (this instanceof com.rpgbattle.HealCaster) {
            options[1] = "Heal";
        } else if (this instanceof com.rpgbattle.DamageCaster) {
            options[1] = "Thunder";
        }

        int choice = 0;
        while (choice < 1 || choice > options.length) {
            System.out.println("\nWhat would you like to do?");
            for (int i = 0; i < options.length; i++) {
                if (options[i] == null) {
                    continue;
                }

                System.out.printf("%d. %s\n", i + 1, options[i]);
            }
            choice = new java.util.Scanner(System.in).nextInt();
        }

        String option =  options[choice - 1].toLowerCase();
        switch (option) {
            case "attack" -> {
                System.out.println();
                System.out.println("Which one do you want to fight?");
                Character enemy = null;
                for (int i = 0; i < enemies.length; i++) {
                    if (enemies[i].getCurrentHP() > 0) {
                        System.out.printf("%d. %s\n", i + 1, enemies[i].toString().trim());
                    } else {
                        System.out.printf("%d. %s (DEAD)\n", i + 1, enemies[i].toString().trim());
                    }
                }
                while (enemy == null) {
                    int en = new java.util.Scanner(System.in).nextInt() - 1;
                    if (en >= 0 && en < enemies.length && enemies[en].getCurrentHP() > 0) {
                        enemy = enemies[en];
                    } else {
                        System.out.print("\nInvalid choice. Try again: ");
                    }
                }
                attack(enemy);
            }
            case "heal" -> ((com.rpgbattle.HealCaster) this).heal(allies);
            case "thunder" -> ((com.rpgbattle.DamageCaster) this).thunder(enemies);
        }
    }
}
