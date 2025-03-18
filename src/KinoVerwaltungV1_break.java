import java.util.ArrayList;
import java.util.Scanner;

public class KinoVerwaltungV1_break {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // define film table
        String[][] filmData = {
                { "1.", "Batman", "20:15", "1", "verfügbar" },
                { "2.", "Matrix", "22:00", "3", "verfügbar" },
                { "3.", "Matrix 2", "17:00", "0", "ausgebucht" }
        };

        // creating the array list for persistency
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>(); // make compiler happy!

        // defining variables
        int userBudget;
        int userFilm;
        int userTickets;
        int availableTickets;
        int ticketPrice = 15;

        // asking user for budget
        do {
            System.out.println("Wie viel Geld hast du mit?");
            userBudget = sc.nextInt();
        } while (userBudget < 1);

        // loop for user picking a film
        while (true) {

            // film print block
            System.out.println(
                    String.format("%s %10s %12s %15s %15s", "Filmnr", "Filmname", "Uhrzeit", "Tickets",
                            "Restplätzergs"));
            System.out.println("--------------------------------------------------------------");
            for (int i = 0; i < filmData.length; i++) {
                System.out.print(
                        String.format("%3s %12s %12s %15s %15s",
                                (Object[]) filmData[i])); /// idfk how to make compiler happy here
                System.out.println();
            }
            System.out.println("--------------------------------------------------------------");

            // asking user for Film
            do {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                userFilm = sc.nextInt();
                if (userFilm == 0) {
                    break;
                }

            } while (userFilm > filmData.length || userFilm < 0);
            if (userFilm == 0) {
                break;
            }

            // checks for available tickets
            userFilm = userFilm - 1;
            availableTickets = Integer.parseInt(filmData[userFilm][3]);

            // buying function
            do {
                System.out.println(String.format("%s %d %s", "Es sind noch", availableTickets,
                        "Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?"));

                // user input
                userTickets = sc.nextInt();
                if (userTickets == 0) {
                    break;
                }
                if (userBudget >= userTickets * ticketPrice && userTickets <= availableTickets) {
                    // chosen movies array list function
                    for (int i = 0; i < userTickets; i++) {
                        chosenMovies.add(userFilm + 1);
                    }
                    // availablility changes
                    availableTickets = availableTickets - userTickets;
                    String avbTickets = String.valueOf(availableTickets);
                    filmData[userFilm][3] = avbTickets;
                    if (availableTickets == 0) {
                        filmData[userFilm][4] = "ausgebucht";
                    }

                    // formatted print for user
                    System.out.println(String.format("%s %d %s %d %s %d %s", "Du kaufst", userTickets, "Tickets um",
                            userTickets * ticketPrice, "€ und hast jetzt noch", userBudget - userTickets * ticketPrice,
                            "€."));
                } else if (userBudget <= userTickets * ticketPrice) {
                    System.out.println("Du hast nicht genug Geld mit!");
                } else {
                    System.out.println("Nicht genug Tickets vorhanden!");
                }

            } while (availableTickets != 0);
        }
        System.out.println(String.valueOf(chosenMovies));
        sc.close(); // make compiler happy!
    }
}