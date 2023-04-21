import java.util.Random;

public class UndeadBeast extends PlayerCharacter
{
    private int maxHP;
    private int currentHP;
    private int strength;
    private String name;
    
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = ( currentHP < 1 ) ? 0 : currentHP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

   

   
public UndeadBeast()
   {
    super(500, 500, 100, "Undead Beast");
    maxHP = 500;
    currentHP = 500;
    strength = 160;
    name = "Undead Beast";
    

   }
   public UndeadBeast( int maxH, int currentH, int stren, String nombre)
   {
    super(maxH, currentH, stren, nombre); 
    maxHP = ( maxH < 1 ) ? 1 : maxH;
    currentHP = ( currentH < 1 ) ? 1 : currentH;
    strength = ( stren < 1 ) ? 1 : stren;
    name = nombre;
   } 

   @Override
   public void beHealed( int heal){
       System.out.printf("\n%s receives no healing!", getName());
   } 
   
   
   @Override
   public int swing()
   {
      int hit;
      Random rand = new Random();
      hit=(int) ((10-(rand.nextInt(4)))*getStrength()*0.13);
      return hit;
   } // this is math to swing against one person

   public void toSwing(  PlayerCharacter d)
    {
      System.out.printf("\n%s takes a swing!", getName());
      d.setCurrentHP(d.getCurrentHP()-this.swing());
    }

   // return String representation of CommissionEmployee object
   @Override
   public String toString()
   {
      return String.format( "\n%s: %d/%d HP max", getName(),
         getCurrentHP(), getMaxHP()) ;
   } // end method toString


        
} // end class 
