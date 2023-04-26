package com.rpgbattle;
import java.util.Random;
import java.util.Scanner;

public class Fighter extends Character
{
  
public Fighter()
   {
    super(250, 250, 21, "Fighter");
   }

   public Fighter( int maxH, int currentH, int stren, String nombre)
   {
    super(maxH, currentH, stren, nombre); 
   } 

   @Override
   public void attack(  Character d)
    {
       int hit;
       Random rand = new Random();
       hit=(int) ((10-(rand.nextInt(4)))*getStrength());
       d.setCurrentHP(d.getCurrentHP()-hit);
       System.out.printf("\n%s attacks %s for %d damage! %s", getName(), d.getName(), hit, d.toString());
    }

   @Override
   public String toString()
   {
      return String.format( "\n%s: %d/%d HP max", getName(),
         getCurrentHP(), getMaxHP()) ;
   }  

   @Override
   public void move(Character[] allies, Character[] enemies)
   {
                Scanner input = new Scanner(System.in);
                System.out.print("\nHere are the enemies to fight:");
                for (int i = 0; i < enemies.length; i++)
                   System.out.printf("%s (Enter %d to attack)", enemies[i].toString(), i+1);
                System.out.print("\nWhich one do you want to fight?");
                int en = input.nextInt()-1;   
                attack(enemies[en]);

    }
    }
   
 