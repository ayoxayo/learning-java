import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV1 {
    public static void main(String[] args) {
        // init vars and import functions
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int menuOption = -1;

        while (menuOption != 0) {
            do {
                System.out.printf("%s \n%s \n%s \n%s \n%s \n", "Which level do you want to play?", "Level 1", "Level 2",
                        "Level 3", "Quit (Press 0)");
                menuOption = sc.nextInt();
            } while (menuOption < 0 || menuOption > 3);

            int randomNumber = r.nextInt(0, 101);
            int userChance = 9;
            int userGuess = 0;
            boolean yes = true; // the boolean used when asking user whether he wants to repeat level 1, only
                                // used in level 1
            boolean win = false; // to break loop in level2 & level3
            ArrayList<Integer> pastGuesses = new ArrayList<>();

            switch (menuOption) {
                case 1:
                    while (userChance != 0 && yes) {
                        do {
                            System.out.printf("%s \n%s %d %s\n", "Guess a number between 0 and 100!", "You have",
                                    userChance,
                                    "attempts left.");
                            userGuess = sc.nextInt();
                        } while (userGuess < 0 || userGuess > 100);
                        if (userGuess > randomNumber) {
                            System.out.println("The number is smaller than your guess!");
                        } else if (userGuess < randomNumber) {
                            System.out.println("The number is bigger than your guess!");
                        } else {
                            System.out.printf("%s\n%s\n%s\n", "You guessed correct! Congratulations",
                                    "Do you want to try again? (Press 1 for Yes; 0 for No)", "Yes/No");
                            int tryAgain = sc.nextInt();
                            if (tryAgain == 0) {
                                yes = false;
                            } else {
                                randomNumber = r.nextInt(0, 101);
                                userChance = 10;
                            }
                        }
                        userChance--;
                    }
                    break;
                case 2:
                    while (userChance != 0 && !win) {
                        do {
                            System.out.printf("%s \n%s %d %s\n", "Guess a number between 0 and 100!", "You have",
                                    userChance,
                                    "attempts left.");
                            System.out.printf("%s\n%s\n", "Past guesses:", pastGuesses);
                            userGuess = sc.nextInt();
                        } while (userGuess < 0 || userGuess > 100);
                        pastGuesses.add(userGuess);
                        int difference = Math.abs(userGuess - randomNumber);
                        if (userGuess == randomNumber) {
                            System.out.println("You guessed correct! Congratulations");
                            win = true;
                        } else if (difference <= 3) {
                            System.out.println("Almost there! You're 1-3 off!");
                        } else if (difference <= 10) {
                            System.out.println("Relatively close! You're 4-10 off");
                        } else if (difference <= 20) {
                            System.out.println("Not so far away! You're 10-20 off");
                        } else {
                            System.out.println("Far away, you're more than 20 off!");
                        }
                        userChance--;
                    }
                    if (!win) {
                        System.out.println("Too bad, you lost!");
                    }
                    break;
                case 3:
                    boolean turn = r.nextBoolean();
                    int guess = -1;
                    int min = 0;
                    int max = 100;

                    while (!win) {
                        if (turn) {
                            System.out.println("It's your turn!");
                            do {
                                System.out.println("Guess the number!");
                                System.out.println(pastGuesses);
                                guess = sc.nextInt();
                            } while (guess < 0 || guess > 100);
                            pastGuesses.add(guess);
                            if (guess == randomNumber) {
                                System.out.println("You won. Congrats!");
                                win = true;
                            }
                            turn = false;
                        } else {
                            guess = (min + max) / 2;
                            pastGuesses.add(guess);
                            System.out.printf("%s \n%d\n", "It's AIs turn!\nAI guessed:", guess);
                            if (guess == randomNumber) {
                                System.out.println("AI won. You lost!");
                                win = true;
                            }
                            turn = true;
                        }
                        if (guess > randomNumber) {
                            System.out.println("The number is smaller than the guess!");
                            if (guess <= max)
                                max = guess - 1;
                        } else if (guess < randomNumber) {
                            System.out.println("The number is bigger than the guess!");
                            if (guess >= min)
                                min = guess + 1;
                        }
                    }
                    break;
            }
        }
        System.out.println("Bye!");
        sc.close();
    }
}