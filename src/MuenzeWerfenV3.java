import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // define our variables
        // boolean as the random toss
        // integers head and tails for saving the number
        int head = 0;
        int tails = 0;
        int usertoss;

        // adding user defining the throw number in a do loop to keep 'em from doin' what they ain't supposed to
        do {
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
            usertoss = sc.nextInt();
        } while (usertoss < 1 || usertoss > 10 || usertoss % 2 == 0 );

        // the counter
        for (int trow = 1; trow <= usertoss; trow++) { // didn't work previously because it started counting form 0; easier to notice with it being defined here, rather than up
            Random r = new Random(); // adding random
            boolean toss = r.nextBoolean(); // creates the random value
            if (toss) {
                head++;
                System.out.println("Werfe Münze… Kopf!");
            }
            else {
                tails++;
                System.out.println("Werfe Münze… Zahl!");
            }
        }

        // print out sums
        System.out.println("Summe Kopf: " + head);
        System.out.println("Summe Zahl: " + tails);

        // if statement defining who won
        if (head > tails) {
            System.out.println("Ich bekomme das Ticket.");
        }
        else {
            System.out.println("Stefan bekommt das Ticket.");
        }

        // closing scanner
        sc.close();
    }
}
