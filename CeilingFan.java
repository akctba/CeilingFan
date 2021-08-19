import java.util.Scanner;

/**
 * Fan Test Problem Statement:
Using Core Java, Implement a simple ceiling fan with these characteristics:

- The unit has 2 pull cords:
-- One increases the speed each time it is pulled.  There are 3 speed settings, and an “off” (speed 0) setting. 
--- If the cord is pulled on speed 3, the fan returns to the “off” setting.
-- One reverses the direction of the fan at the current speed setting.
--- Once the direction has been reversed, it remains reversed as we cycle through the speed settings, until reversed again.
Assume the unit is always powered (no wall switch)
 */
public class CeilingFan {

    private static String EXIT = "X";
    private static String SPEED = "S";
    private static String DIRECTION = "D";

    public static void main(String args[]) {

        printHeader();

        int speed = 0;
        boolean clockwise = true;
        String key = null;

        Scanner keyboard = new Scanner(System.in);
        do {
            printFanStatus(speed, clockwise);
            System.out.print("Pull a cord (S/D) and press enter: ");

            key = keyboard.nextLine();
            if (key!=null && key.length() > 0) {
                key = key.substring(0, 1).toUpperCase();
                if (SPEED.equals(key)) {
                    speed = (speed<3?speed+1:0);
                } else if (DIRECTION.equals(key)) {
                    clockwise = !clockwise;
                } else if (EXIT.equals(key)) {
                    break;
                } else {
                    System.out.println("Not recognized command.");
                }
            }
            
        } while(true);
        
        keyboard.close();
        System.out.println("\n --  End of ceiling fan simulation. --\n");
    }

    private static void printFanStatus(int speed, boolean direction) {
        System.out.printf(" Fan Speed [%d] Direction [%S] \n", speed, direction?"Clockwise":"Anticlockwise");
    }

    private static void printHeader() {
        System.out.println("=============================================");
        System.out.println(" CEILING FAN CONTROLLER ");
        System.out.println("=============================================");
        System.out.println(" THIS CEILING FAN HAS 2 CORDS: ");
        System.out.println(" S - changes speed in this sequence: Off->1->2->3->Off ");
        System.out.println(" D - reverses the direction: Clockwise<->Anticlockwise ");
        System.out.println(" -------------------------------------------- ");
        System.out.println(" X - Exits the simulation (or Ctrl+c) ");
        System.out.println(" -------------------------------------------- \n\n");
    }
}