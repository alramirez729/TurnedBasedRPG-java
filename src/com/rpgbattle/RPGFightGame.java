package com.rpgbattle;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.rpgbattle.Fighter;
import com.rpgbattle.Warlock;
import com.rpgbattle.Cleric;
import com.rpgbattle.RedMage;
import com.rpgbattle.Character;
import com.rpgbattle.UndeadBeast;
import com.rpgbattle.Character;

public class RPGFightGame {
    static int wavesDefeated = 0;

    private static int getMenuChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add Fighter");
        System.out.println("2. Add Warlock");
        System.out.println("3. Add Cleric");
        System.out.println("4. Add Red Mage");
        System.out.print("Choice: ");

        return input.nextInt();
    }

    public static void toStringAllies(Character[] allies) {
        System.out.print("\nAllies:");
        for (Character ally : allies) System.out.printf("%s", ally.toString());
    }

    public static void toStringEnemies(Character[] enemies) {
        System.out.print("\nEnemies:");
        for (int i = 0; i < enemies.length; i++)
            System.out.printf("%s", enemies[i].toString());
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Character[] allies = new Character[4];

        for (int i = 0; i < allies.length; i++) {
            int choice = getMenuChoice();
            switch (choice) {
                case 1 -> {
                    Fighter a = new Fighter();
                    allies[i] = a;
                }
                case 2 -> {
                    Warlock b = new Warlock();
                    allies[i] = b;
                }
                case 3 -> {
                    Cleric c = new Cleric();
                    allies[i] = c;
                }
                case 4 -> {
                    RedMage d = new RedMage();
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
                        System.out.printf("%s (choose a move)", currentAlly.toString());
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

    public static boolean didPlayerSurvive(Character[] allies) {
        for (Character currentAlly : allies) {
            if (currentAlly.getCurrentHP() != 0) return false;
        }
        return true;
    }

    public static boolean didEnemiesSurvive(Character[] enemies) {
        for (Character currentEnemy : enemies) {
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

