import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV2 {
    public static void main(String[] args) {
        int head = 0;
        int tails = 0;
        int usertoss = 0;
        // adding user input for throw number
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie viele Münzwurfe?");
        usertoss = sc.nextInt();
        sc.close(); // closing the scanner
        // the counter
        for (int trow =1 ;trow <= usertoss; trow++) {
            Random r = new Random();
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
        if (head == tails) {
            System.out.println("Unentschieden");
        }
        else if (head > tails) {
            System.out.println("Ich bekomme das Ticket.");
        }
        else {
            System.out.println("Stefan bekommt das Ticket.");
        }
    }
}
