package com.rpgbattle;

public abstract class PlayerCharacter implements Healable
{
   private int maxHP;
   private int currentHP;
   private int strength;
   private String name;
   
     

   public PlayerCharacter( int maxH, int currentH, int stren, String nombre )
   {
      maxHP = ( maxH < 1 ) ? 1 : maxH;
      currentHP = ( currentH < 1 ) ? 1 : currentH;
      strength = ( stren < 1 ) ? 1 : stren;
      name = nombre;
   } 

   public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }
   public void setMaxHP( int max )
   {
      maxHP = max;
   } 
   public int getMaxHP()
   {
      return maxHP;
   } 
   public void setCurrentHP( int current )
   {
      currentHP = ( current < 1 ) ? 0 : current;
   }

   public int getCurrentHP()
   {
      return currentHP;
   } 

   public void setStrength( int stren )
   {
      strength = stren; 
   } 

   public int getStrength()
   {
      return strength;
   } 

   public int swing()
   {
    return 0;
   }
   // return String representation of Employee object
   public String toString()
   {
      return String.format( "%d/%d HP max", 
         getCurrentHP(), getMaxHP()) ;
   } // end method toString

   
  // public abstract double earnings(); // no implementation here
   // Note: We do not implement Payable method getPaymentAmount here so 
   // this class must be declared abstract to avoid a compilation error.
} // end abstract class Employee
