package com.rpgbattle;

public abstract class Character 
{
   private int maxHP;
   private int currentHP;
   private int strength;
   private String name;
   
     

   public Character( int maxH, int currentH, int stren, String nombre )
   {
      maxHP = Math.max(maxH, 1);
      currentHP = Math.max(currentH, 1);
      strength = Math.max(stren, 1);
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

   public void attack(Character d)
   {

   }
   
   public String toString()
   {
      return String.format( "%d/%d HP max", 
         getCurrentHP(), getMaxHP()) ;
   } 

   public void move(Character[] allies, Character[] enemies)
   {

   }
  
} 
