import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KinoVerwaltungV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // welcome and set budget
        System.out.println("Welcome to the cinema!");
        double userBudget;
        do {
            System.out.println("How much money do you have with you?");
            userBudget = sc.nextInt();
        } while (userBudget < 1);

        // set vars and arrays
        int menuOption = -1;
        int userTickets;
        // creating the array list for persistency
        ArrayList<Integer> chosenMovies = new ArrayList<Integer>(); // make compiler happy!
        // define film table /nr, name, time, room, price, status, tickets
        String[][] filmData = {
                { "1.", "Batman", "20:15", "1", "12.50", "available", "4" },
                { "2.", "Matrix", "22:00", "3", "15.00", "available", "3" },
                { "3.", "Matrix 2", "17:00", "2", "9.99", "available", "1" }
        };

        while (menuOption != 4) {
            do {
                System.out.printf("%s %.2f %s \n %s \n %s \n %s \n %s ", "What do you want to do? You still have",
                        userBudget, "€ remaining.", "1. Buy tickets",
                        "2. Watch a movie", "3. Lottery!", "4. Exit");
                menuOption = sc.nextInt();
            } while (menuOption < 0 || menuOption > 4);

            switch (menuOption) {
                case 1:
                    // init vars
                    int userFilm;
                    int availableTickets;
                    double ticketPrice;

                    // print the film array
                    System.out.printf(
                            "%s %-10s %-12s %-7s %-8s %-15s \n", "Nr.", "Name", "Time", "Room", "Price",
                            "Availability");
                    System.out.println("--------------------------------------------------------------");
                    for (int i = 0; i < filmData.length; i++) {
                        // checking availability and adjusting
                        int ticketCheck = Integer.parseInt(filmData[i][6]);
                        String status = "unavailable";
                        if (ticketCheck == 0) {
                            filmData[i][5] = status;
                        }
                        System.out.printf(
                                "%-3s %-10s %-13s %-7s %-8s %-15s\n",
                                (Object[]) filmData[i]); // (Object[])
                    }
                    System.out.println("--------------------------------------------------------------");

                    // picking a film
                    do {
                        System.out.println("Which available film would you like to watch? (Press 0 to cancel)");
                        userFilm = sc.nextInt();
                    } while (userFilm > filmData.length || userFilm < 0);

                    if (userFilm != 0) {
                        // checks for available tickets
                        availableTickets = Integer.parseInt(filmData[userFilm - 1][6]);
                        if (availableTickets != 0) {
                            // asking for user input
                            ticketPrice = Double.parseDouble(filmData[userFilm - 1][4]); // issues, issues ask4help
                            System.out.printf("%s %d %s %.2f %s \n", "There are", availableTickets,
                                    "tickets, for", ticketPrice, "€ each. How many of them would you like to buy?");

                            // user input
                            userTickets = sc.nextInt();

                            // buying function
                            if (userTickets >= 0 && userBudget >= userTickets * ticketPrice
                                    && userTickets <= availableTickets) {

                                // money shift
                                userBudget = userBudget - userTickets * ticketPrice;

                                // chosen movies array list function
                                for (int i = 0; i < userTickets; i++) {
                                    chosenMovies.add(userFilm);
                                }

                                // availablility changes
                                availableTickets = availableTickets - userTickets;
                                String avbTickets = String.valueOf(availableTickets);
                                filmData[userFilm - 1][6] = avbTickets;
                                System.out.println(filmData[userFilm - 1][6]);

                                // formatted print for user
                                System.out.printf(
                                        "%s %d %s %.2f %s %.2f %s \n", "You purchased", userTickets, "Tickets for",
                                        userTickets * ticketPrice, "€ and still have",
                                        userBudget,
                                        "€ remaining.");
                            } else if (userBudget < userTickets * ticketPrice) {
                                System.out.println("You don't have enough money!");
                            } else {
                                System.out.println("There aren't enough tickets!");
                            }
                        } else if (availableTickets == 0) {
                            System.out.println("No available tickets for that movie!");
                        }
                    }
                    break;
                case 2:
                    if (!chosenMovies.isEmpty()) { // checking the array to see if it's empty
                        // checker and printer loop
                        for (int i = 0; i < chosenMovies.size(); i++) {
                            System.out.printf("%d. %s \n", i + 1, filmData[chosenMovies.get(i) - 1][1]);
                        }

                        // user input and validator
                        int watchedMovie = -1;
                        do {
                            System.out.println("Which one do you want to watch? (Press 0 to cancel)");
                            watchedMovie = sc.nextInt();
                        } while (watchedMovie > chosenMovies.size() || watchedMovie < 0);
                        if (watchedMovie != 0) {
                            System.out.printf("%s %s. \n", "You watched",
                                    filmData[chosenMovies.get(watchedMovie - 1) - 1][1]);
                            // change chosenMovies values
                            chosenMovies.remove(watchedMovie - 1);
                        }

                    } else {
                        System.out.println("You don't have any tickets!");
                    }
                    break;
                case 3:
                    if (userBudget >= 5) {
                        Random r = new Random();
                        int lotteryNumber = r.nextInt(10, 1000);
                        System.out.printf("%s \n %s %d! \n", "You enter the lottery! Good luck!",
                                "Your lucky number is", lotteryNumber);

                        int n = lotteryNumber;
                        int sum = 0;

                        while (n != 0) {
                            sum += n % 10;
                            n = n / 10;
                        }

                        if (sum > 16) {
                            System.out.println(
                                    "You win! The digit sum of your lucky number is higher than 16! Congratulations!");
                            userBudget += 20;
                        } else {
                            System.out.println("You lost! Boo-hoo");
                            userBudget -= 5;
                        }
                    } else {
                        System.out.println("You don't have enough money!");
                    }

                    break;
            }
        }
        System.out.println("Buh-Bye!");

        sc.close(); // make compiler happy!
    }
}
