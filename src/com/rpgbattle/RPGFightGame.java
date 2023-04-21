import java.util.Scanner;

public class RPGFightGame {
    private static int getMenuChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add Undead Beast");
        System.out.println("2. Add Warlock");
        System.out.println("3. Add Cleric");
        System.out.println("4. Add Red Mage");
        System.out.print("Choice: ");


        return input.nextInt();
    }
    // end method getMenuChoice


    public static void toStringAllies(PlayerCharacter allies[]) {
        for (int i = 0; i < 4; i++)
            System.out.printf("%s", allies[i].toString());
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);


        PlayerCharacter allies[] = new PlayerCharacter[4];

        for (int i = 0; i < 4; i++) {
            int choice = getMenuChoice();
            switch (choice) {
                case 1: // UDB
                    System.out.print("\nEnter a name for this Undead Beast:");
                    String nomen = input.nextLine();
                    UndeadBeast a = new UndeadBeast(500, 500, 160, nomen);
                    allies[i] = a;

                    break;
                case 2: // Warlock
                    System.out.print("\nEnter a name for this Warlock:");
                    String noman = input.nextLine();
                    Warlock b = new Warlock(250, 250, 100, 100, 70, 100, noman);
                    allies[i] = b;

                    break;
                case 3: // Cleric
                    System.out.print("\nEnter a name for this Cleric:");
                    String nomon = input.nextLine();
                    Cleric c = new Cleric(250, 250, 100, 100, 70, 100, nomon);
                    allies[i] = c;

                    break;
                case 4:
                    System.out.print("\nEnter a name for this Red Mage:");
                    String nomin = input.nextLine();
                    RedMage d = new RedMage(250, 250, 50, 50, 100, 100, nomin);
                    allies[i] = d;
                    break;
            } // end switch
        }
        toStringAllies(allies);
        input.close();
    }
}

// prints a menu and returns a value corresponding to the menu choice
   /*private static int getMenuChoice()
   {
      Scanner input = new Scanner( System.in );
      
      System.out.println( "1. Add Undead Beast" );
      System.out.println( "2. Add Warlock" );
      System.out.println( "3. Add Cleric" );
      System.out.println( "4. Add Red Mage" );
      System.out.print( "Choice: " );
      
      
      
      return input.nextInt();
   } // end method getMenuChoice

  

   public static void toStringAllies(PlayerCharacter allies[])
   {
      for (int i=0; i < 4; i++)
         System.out.printf("%s", allies[i].toString());
   }
   }
 */
