import java.util.Random;

public class RedMage extends PlayerCharacter implements DamageCaster, HealCaster
{
    private int maxHP;
    private int currentHP;
    private int strength;
    private int currentMP;
    private int maxMP;
    private int intelligence;
    private String name;

    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public int getIntelligence() {
    return intelligence;
}

    public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
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
        //this.currentHP = ( currentHP < 1 && currentHP > getMaxHP() ) ? 0 : currentHP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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
   

   
   public RedMage()
   {
    super(250, 250, 70, "Red Mage");
    maxHP = 250;
    currentHP = 250;
    strength = 100;
    maxMP = 50;
    currentMP = 50;
    intelligence = 100;
    name = "Red Mage";

   }
   public RedMage( int maxH, int currentH, int maxM, int currentM, int stren, int intel, String nombre)
   {
      super(maxH, currentH, stren, nombre);
      maxHP = maxH;
      currentHP = currentH;
      strength = stren;
      maxMP = ( maxH < 20 ) ? 20 : maxM;
      currentMP = ( currentM < 0 ) ? 0 : currentM;
      intelligence = ( intel < 1 ) ? 1 : intel;
      name = nombre;
   } 

   @Override
   public void beHealed(int heal){
       if (getCurrentHP()!=0)
       {
       int FixedHeal = ( heal + getCurrentHP() >= getMaxHP() ) ? getMaxHP() : heal; 
       setCurrentHP(FixedHeal);
       System.out.printf("\n%s received healing!", getName());
       }
       else
       {
        System.out.printf("\n%s is dead and cannot be healed.", getName());
       }
   } 
   
    @Override
   public int castThunder(){
      
       int thunder;
       Random rand = new Random();
       thunder=(int) ((20-(rand.nextInt(4)))*getIntelligence()*0.33);
       return thunder;
   } //this method is how much an enemy would receive, and will need to be done again for each enemy

   public void toThunder(  PlayerCharacter[] enemies)
    {
        if (getCurrentMP()>=20)
    {
       System.out.printf("\n%s casts Thunder on all enemies!", getName());
       setCurrentMP(getCurrentMP()-20);  
       for ( PlayerCharacter currentEnemy : enemies )
       {
        currentEnemy.setCurrentHP(currentEnemy.getCurrentHP()-this.castThunder());
        System.out.printf("%s", currentEnemy.toString());
       }
    }
    else
       {
        System.out.printf("\n%s needs 20 MP to cast Thunder!", getName()); 
       }  
    }
    
    public void toCastHeal(  PlayerCharacter[] allies)
    {
        if (getCurrentMP()>=20)
    {
       System.out.printf("\n%s casts Heal on all allies!", getName());
       setCurrentMP(getCurrentMP()-20);  
       for ( PlayerCharacter currentAlly : allies )
       {
        currentAlly.beHealed(currentAlly.getCurrentHP()+this.castHeal());
        System.out.printf("%s", currentAlly.toString());
       }
    }
    else
       {
        System.out.printf("\n%s needs 20 MP to cast Heal!", getName()); 
       }  
    }

    @Override
    public int castHeal(){
       int heal;
       Random rand = new Random();
       heal=(int) ((20-(rand.nextInt(4)))*getIntelligence()*0.33);
       return heal;
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

   @Override
   public String toString()
   {
      return String.format( "\n%s: %s, %d/%d MP max",
         getName(), super.toString(), 
         getCurrentMP(), getMaxMP()); 
        
   } // end method toString
} // end class 
