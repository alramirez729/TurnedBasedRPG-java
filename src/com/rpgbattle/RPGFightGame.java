package com.rpgbattle;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import com.rpgbattle.GameGUI.CustomOutputStream;
import java.awt. *;
import javax.swing.*;
import com.rpgbattle.GameGUI;
import com.rpgbattle.Character;
import com.rpgbattle.DamageCaster;
import com.rpgbattle.HealCaster;
import com.rpgbattle.Fighter;
import com.rpgbattle.Cleric;
import com.rpgbattle.UndeadBeast;
import com.rpgbattle.RedMage;
import com.rpgbattle.Warlock;


public class RPGFightGame {
    static int wavesDefeated = 0;


    private static int getMenuChoice() {
        String[] options = {"Add Fighter", "Add Warlock", "Add Cleric", "Add Red Mage"};
        int choice = JOptionPane.showOptionDialog(null, "Choose a character:", "Character Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return choice + 1;
    }

    public static void toStringAllies(Character[] allies) {
        System.out.print("\nAllies:");
        for (Character ally : allies) System.out.printf("%s", ally.toString());
    }

    public static void toStringEnemies(Character[] enemies) {
        System.out.print("\n\nEnemies:");
        for (Character enemy : enemies) System.out.printf("%s", enemy.toString());
    }

    public static void main(String[] args) {
        GameGUI window = new GameGUI();

        System.out.println("\t\tHello Player! \n \t        Welcome! To RPGFightGame! ");
        Character[] allies = new Character[4];

        PrintStream printStream = new PrintStream(new CustomOutputStream(window.getTextArea()));

        for (int i = 0; i < allies.length; i++) {
            int choice = getMenuChoice();
            switch (choice) {
                case 1 -> {
                    Fighter a = new Fighter();
                    System.out.println("FIGHTER CHOSEN.");
                    allies[i] = a;
                }
                case 2 -> {
                    Warlock b = new Warlock();
                    System.out.println("WARLOCK CHOSEN.");
                    allies[i] = b;
                }
                case 3 -> {
                    Cleric c = new Cleric();
                    System.out.println("CLERIC CHOSEN.");
                    allies[i] = c;
                }
                case 4 -> {
                    RedMage d = new RedMage();
                    System.out.println("RED MAGE CHOSEN.");
                    allies[i] = d;
                }
            } // end switch
        }
        boolean playerAlive = true;
        do {
            toStringAllies(allies);
            Character[] enemies = createEnemies();
            toStringEnemies(enemies);
            boolean enemiesToKill = true;
            do {
                for (Character currentAlly : allies) {
                    if (currentAlly.getCurrentHP() != 0) {
                        System.out.printf("%s (choose a move)", currentAlly);
                        currentAlly.move(allies, enemies);
                        if ((didEnemiesSurvive(enemies))) {
                            playerDefeatedAWave();
                            enemiesToKill = false;
                            break;
                        }
                    } else System.out.printf("\n%s is dead and cannot move.", currentAlly.getName());
                }
                for (Character currentEnemy : enemies) {
                    if (currentEnemy.getCurrentHP() != 0) {
                        currentEnemy.move(allies, enemies);
                        if ((didPlayerSurvive(allies))) {
                            enemiesToKill = false;
                            playerAlive = false;
                            break;
                        }
                    }
                    //else System.out.printf("\n%s is dead and cannot move.", currentEnemy.getName());
                }
                //toStringAllies(allies);
            } while (enemiesToKill);
        } while (playerAlive);
        playerLost();
    }//end main


    public static Character[] createEnemies() {
        Random rand = new Random();
        int whichEnemyWave = rand.nextInt(4);
        if (whichEnemyWave == 0) {
            Character[] enemies = new Character[6];
            for (int i = 0; i < enemies.length; i++)
                enemies[i] = new UndeadBeast();
            return enemies;
        }
        if (whichEnemyWave == 1) {
            Character[] enemies = new Character[1];
            enemies[0] = new UndeadBeast(2000, 2000, 21, "Massive Undead Beast");
            return enemies;
        }
        if (whichEnemyWave == 2) {
            Character[] enemies = new Character[4];
            enemies[0] = new UndeadBeast(750, 750, 21, "Big Undead Beast");
            enemies[1] = new UndeadBeast();
            enemies[2] = new UndeadBeast(750, 750, 21, "Big Undead Beast");
            enemies[3] = new UndeadBeast(500, 500, 21, "Undead Beast");
            return enemies;
        }
        if (whichEnemyWave == 3) {
            Character[] enemies = new Character[2];
            enemies[0] = new UndeadBeast(1000, 1000, 21, "Huge Undead Beast");
            enemies[1] = new UndeadBeast(1000, 1000, 21, "Huge Undead Beast");
            return enemies;
        }
        Character[] enemies = new Character[6];
        enemies[0] = new UndeadBeast();
        enemies[1] = new UndeadBeast();
        enemies[2] = new UndeadBeast();
        enemies[3] = new UndeadBeast();
        enemies[4] = new UndeadBeast();
        enemies[5] = new UndeadBeast();
        return enemies;
    }

    public static boolean didPlayerSurvive(com.rpgbattle.Character[] allies) {
        for (com.rpgbattle.Character currentAlly : allies) {
            if (currentAlly.getCurrentHP() != 0) return false;
        }
        return true;
    }

    public static boolean didEnemiesSurvive(com.rpgbattle.Character[] enemies) {
        for (com.rpgbattle.Character currentEnemy : enemies) {
            if (currentEnemy.getCurrentHP() != 0) return false;
        }
        return true;
    }

    public static void playerDefeatedAWave() {
        wavesDefeated++;
        System.out.printf("\nCongratulations! You defeated %d waves of enemies so far.", wavesDefeated);
    }

    public static void playerLost() {
        System.out.print("\nYour party is dead. Game over.");
        System.out.printf("\nCongratulations! You defeated %d waves of enemies.", wavesDefeated);
    }

}
