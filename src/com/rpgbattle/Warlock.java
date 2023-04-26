package com.rpgbattle;
import java.util.Random;
import java.util.Scanner;
import com.rpgbattle.Character;
import com.rpgbattle.DamageCaster;

public class Warlock extends Character implements DamageCaster
{
    private int currentMP;
    private int maxMP;
    private int intelligence;
    
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
   

   
   public Warlock()
   {
    super(250, 250, 9, "Warlock");
    maxMP = 100;
    currentMP = 100;
    intelligence = 33;
    

   }
   public Warlock( int maxH, int currentH, int maxM, int currentM, int stren, int intel, String nombre)
   {
      super(maxH, currentH, stren, nombre);
      maxMP = ( maxH < 20 ) ? 20 : maxM;
      currentMP = ( currentM < 0 ) ? 0 : currentM;
      intelligence = ( intel < 1 ) ? 1 : intel;
   } 

@Override
   public void thunder(  Character[] enemies)
    {
        if (getCurrentMP()>=20)
    {
       System.out.printf("\n%s casts Thunder on all enemies!", getName());
       setCurrentMP(getCurrentMP()-20);  
       for ( Character currentEnemy : enemies )
       {
        int thunder;
        Random rand = new Random();
        thunder=(int) ((20-(rand.nextInt(4)))*getIntelligence());
        currentEnemy.setCurrentHP(currentEnemy.getCurrentHP()-thunder);
        System.out.printf("%s", currentEnemy.toString());
       }
    }
    else
       {
        System.out.printf("\n%s needs 20 MP to cast Thunder!", getName()); 
       }  
       System.out.println();
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
      return String.format( "\n%s: %s, %d/%d MP max",
         getName(), super.toString(), 
         getCurrentMP(), getMaxMP()); 
        
   } 

   @Override
   public void move(Character[] allies, Character[] enemies)
   {
        Scanner input = new Scanner(System.in);
        System.out.println("\n1. Fight");
        System.out.println("2. Thunder");
        System.out.print("Choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1: // Fight
                System.out.print("\nHere are the enemies to fight:");
                for (int i = 0; i < enemies.length; i++)
                   System.out.printf("%s (Enter %d to attack)", enemies[i].toString(), i+1);
                System.out.print("\nWhich one do you want to fight?");
                int en = input.nextInt()-1;   
                attack(enemies[en]);

                break;
            case 2: 
                thunder(enemies);
        } // end switch
    }
   }
