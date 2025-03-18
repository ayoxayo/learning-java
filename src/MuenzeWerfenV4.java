import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV4 {
    public static void main(String[] args) {

        // initializing scanner
        Scanner sc = new Scanner(System.in);

        // defining variables
        int heads = 0;
        int tails = 0;
        int usertoss;
        boolean satisfaction = false;
        // satisfaction loop
        while (!satisfaction) {
            // if statements to filter out even numbers
            do {
                System.out.println("Wie oft soll die Münze geworfen werden (INSGESAMT ungerade, neue Zahl 1-10)?");
                usertoss = sc.nextInt();
            } while (usertoss < 1 || usertoss > 10 || (heads + tails + usertoss) % 2 == 0);
            for (int trow = 1; trow <= usertoss; trow++) { //
                // add randomness
                Random r = new Random();
                boolean toss = r.nextBoolean(); // creates the random value
                // counts
                if (toss) {
                    heads++;
                    System.out.println("Werfe Münze… Kopf!");
                } else {
                    tails++;
                    System.out.println("Werfe Münze… Zahl!");
                }
            } // for counter loop finished
              // print out sums
            System.out.println("Summe Kopf: " + heads);
            System.out.println("Summe Zahl: " + tails);
            // are you satisfied?
            System.out.println("Bist du mit dem Ergebnis zufrieden?");
            satisfaction = sc.nextBoolean();
        }
        // printing the results
        if (heads > tails) {
            System.out.println("Ich bekomme das Ticket.");
        } else {
            System.out.println("Stefan bekommt das Ticket.");
        }
        sc.close(); // closing scanner
    }
}
