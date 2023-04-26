package com.rpgbattle;
import java.util.Random;

public class UndeadBeast extends Character
{
  
public UndeadBeast()
   {
    super(500, 500, 21, "Undead Beast");
   }

   public UndeadBeast( int maxH, int currentH, int stren, String nombre)
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
        Random rand = new Random();
        attack(allies[rand.nextInt(4)]);
    }
    }

