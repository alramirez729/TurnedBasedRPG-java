package com.rpgbattle;
import java.util.Random;
import java.util.Scanner;

public class Cleric extends Character implements HealCaster
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
   
   public Cleric()
   {
    super(250, 250, 9, "Cleric");
    maxMP = 100;
    currentMP = 100;
    intelligence = 33;

   }
   public Cleric( int maxH, int currentH, int maxM, int currentM, int stren, int intel, String nombre)
   {
    super(maxH, currentH, stren, nombre);
    maxMP = ( maxH < 20 ) ? 20 : maxM;
    currentMP = ( currentM < 0 ) ? 0 : currentM;
    intelligence = ( intel < 1 ) ? 1 : intel;
   } 

@Override
   public void heal(  Character[] allies)
    {
        if (getCurrentMP()>=20)
    {
       System.out.printf("\n%s casts Heal on all allies!", getName());
       setCurrentMP(getCurrentMP()-20);  
       for ( Character currentAlly : allies )
       {
        if (currentAlly.getCurrentHP()!=0)
        {
        int heal;
        Random rand = new Random();
        heal=(int) ((20-(rand.nextInt(4)))*getIntelligence());   
        int FixedHeal = ( heal + currentAlly.getCurrentHP() >= currentAlly.getMaxHP() ) ? currentAlly.getMaxHP() : heal; 
        currentAlly.setCurrentHP(FixedHeal);
        System.out.printf("%s", currentAlly.toString());
        }
        else
        {
         System.out.printf("\n%s is dead and cannot be healed.", currentAlly.getName());
        }
       }
    }
    else
       {
        System.out.printf("\n%s needs 20 MP to cast Heal!", getName()); 
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
        System.out.println("2. Heal");
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
                heal(allies);
        } // end switch
    }

} 
   @Override
   public String toString()
   {
      return String.format( "\n%s: %s, %d/%d MP max",
         getName(), super.toString(), 
         getCurrentMP(), getMaxMP()); 
        
   } // end method toString
} // end class 
