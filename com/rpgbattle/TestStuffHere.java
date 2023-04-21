package com.rpgbattle;

public class TestStuffHere {
    
   public static void main( String args[] ) 
   {
      
    UndeadBeast a = new UndeadBeast();
    UndeadBeast b = new UndeadBeast();
    Warlock c = new Warlock();
    Warlock d = new Warlock(700, 700, 100, 100, 100, 100, "Harry");
    Cleric e = new Cleric();
    PlayerCharacter allies[] = {a, b, c, d, e};
    System.out.printf("%s", b.toString());
    System.out.printf("%s", d.toString());
    a.toSwing( b);
    c.toSwing( d);
    //b.setCurrentHP(b.getCurrentHP()-a.swing());
    //d.setCurrentHP(d.getCurrentHP()-c.swing());
    System.out.printf("%s", b.toString());
    e.toCastHeal(allies);
    //b.beHealed(b.getCurrentHP()+e.castHeal());
    //d.beHealed(d.getCurrentHP()+e.castHeal());
    System.out.printf("%s", d.toString());
    a.toSwing(d);
   // d.setCurrentHP(d.getCurrentHP()-a.swing());
    System.out.printf("%s", d.toString());
    a.toSwing(d);
    //d.setCurrentHP(d.getCurrentHP()-a.swing());
    System.out.printf("%s", d.toString());
    b.setCurrentHP(b.getCurrentHP()-d.castThunder());
    System.out.printf("%s", b.toString());
    System.out.printf("%s", d.toString());
   
      PlayerCharacter enemies[] = new PlayerCharacter[2];
      enemies[0] = new UndeadBeast();
      enemies[1] = new UndeadBeast();
    d.toThunder(enemies);
    System.out.printf("%s", d.toString());
    

    

     /* 
    // create five-element Employee array
      Employee employees[] = new Employee[ 2 ]; 

      // initialize array with Employees
      employees[ 0 ] = new SalariedEmployee( 
         "John", "Smith", "111-11-1111", 800.00 );
      employees[ 1 ] = new HourlyEmployee( 
         "Karen", "Price", "222-22-2222", 16.75, 40 );
      employees[ 2 ] = new CommissionEmployee( 
         "Sue", "Jones", "333-33-3333", 10000, .06 ); 
      employees[ 3 ] = new BasePlusCommissionEmployee( 
         "Bob", "Lewis", "444-44-4444", 5000, .04, 300 );
      employees[ 4 ] = new PieceWorker( 
         "Bobbitha", "Lewinski", "555-55-5555", 2.40, 300);
     */
    /* 
      System.out.println( "Employees processed polymorphically:\n" );
      
      // generically process each element in array employees
      for ( Employee currentEmployee : employees ) 
      {
         System.out.println( currentEmployee ); // invokes toString
         System.out.printf( 
            "earned $%,.2f\n\n", currentEmployee.earnings() );
      } // end for
   } // end main
  */
} // end class PayrollSystemTest



}
