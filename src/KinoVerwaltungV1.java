import java.util.ArrayList;
import java.util.Scanner;

public class KinoVerwaltungV1 {
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
        int userFilm = -1;
        int userTickets;
        int availableTickets;
        int ticketPrice = 15;

        // asking user for budget / make sure input is OK
        do {
            System.out.println("Wie viel Geld hast du mit?");
            userBudget = sc.nextInt();
        } while (userBudget < 1);

        while (userFilm != 0) {
            // print film table
            System.out.printf(
                    "%s %10s %12s %15s %15s", "Filmnr", "Filmname", "Uhrzeit", "Tickets",
                    "Restplätzergs");
            System.out.println("--------------------------------------------------------------");
            for (int i = 0; i < filmData.length; i++) {
                System.out.printf(
                        "%3s %12s %12s %15s %15s\n", filmData[i]); /// idfk how to make compiler happy here
            }
            System.out.println("--------------------------------------------------------------");

            // picking a film
            do {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                userFilm = sc.nextInt();
            } while (userFilm > filmData.length || userFilm < 0);

            if (userFilm != 0) {
                // checks for available tickets
                availableTickets = Integer.parseInt(filmData[userFilm - 1][3]);

                // buying function
                System.out.printf("%s %d %s %d %s", "Es sind noch", availableTickets,
                        "Tickets um jeweils", ticketPrice, "€ dafür verfügbar. Wie viele möchtest du kaufen?");

                // user input
                userTickets = sc.nextInt();

                // buying function
                if (userTickets >= 0 && userBudget >= userTickets * ticketPrice && userTickets <= availableTickets) {

                    // money shift
                    userBudget = userBudget - userTickets * ticketPrice;

                    // chosen movies array list function
                    for (int i = 0; i < userTickets; i++) {
                        chosenMovies.add(userFilm);
                    }

                    // availablility changes
                    availableTickets = availableTickets - userTickets;
                    String avbTickets = String.valueOf(availableTickets);
                    filmData[userFilm - 1][3] = avbTickets;
                    if (availableTickets == 0) {
                        filmData[userFilm - 1][4] = "ausgebucht";
                    }

                    // formatted print for user
                    System.out.printf(
                            "%s %d %s %d %s %d %s", "Du kaufst", userTickets, "Tickets um",
                            userTickets * ticketPrice, "€ und hast jetzt noch",
                            userBudget,
                            "€.");
                } else if (userBudget < userTickets * ticketPrice) {
                    System.out.println("Du hast nicht genug Geld mit!");
                } else {
                    System.out.println("Nicht genug Tickets vorhanden!");
                }

            }
        }

        System.out.println(String.valueOf(chosenMovies));
        sc.close(); // make compiler happy!
    }
}