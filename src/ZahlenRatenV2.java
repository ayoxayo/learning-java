import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV2 {
    public static void main(String[] args) {
        // init vars and import functions
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int menuOption = -1;

        int randomNumber;
        int userChance;
        int guess = 0;
        // level 1
        boolean yes = true; // the boolean used when asking user whether he wants to repeat level 1
        // level 2 / 3 / 4
        boolean win = false; // breaking loop
        boolean turn; // turns
        int difference;
        int min; // range
        int max; // range
        ArrayList<Integer> pastGuesses = new ArrayList<>();

        while (menuOption != 0) {
            do {
                System.out.printf("%s \n%s \n%s \n%s \n%s \n%s \n", "Which level do you want to play?", "Level 1",
                        "Level 2",
                        "Level 3", "Level 4", "Quit (Press 0)");
                menuOption = sc.nextInt();
            } while (menuOption < 0 || menuOption > 4);
            switch (menuOption) {
                case 1:
                    randomNumber = r.nextInt(0, 101);
                    userChance = 9;
                    while (userChance != 0 && yes) {
                        do {
                            System.out.printf("%s \n%s %d %s\n", "Guess a number between 0 and 100!", "You have",
                                    userChance,
                                    "attempts left.");
                            guess = sc.nextInt();
                        } while (guess < 0 || guess > 100);
                        if (guess > randomNumber) {
                            System.out.println("The number is smaller than your guess!");
                        } else if (guess < randomNumber) {
                            System.out.println("The number is bigger than your guess!");
                        } else {
                            System.out.printf("%s\n%s\n%s\n", "You guessed correct! Congratulations",
                                    "Do you want to try again? (Press 1 for Yes; 0 for No)", "Yes/No");
                            int tryAgain = sc.nextInt();
                            if (tryAgain == 0) {
                                yes = false;
                            } else {
                                userChance = 10;
                            }
                        }
                        userChance--;
                    }
                    break;
                case 2:
                    randomNumber = r.nextInt(0, 101);
                    userChance = 9;
                    while (userChance != 0 && !win) {
                        do {
                            System.out.printf("%s \n%s %d %s\n", "Guess a number between 0 and 100!", "You have",
                                    userChance,
                                    "attempts left.");
                            System.out.printf("%s\n%s\n", "Past guesses:", pastGuesses);
                            guess = sc.nextInt();
                        } while (guess < 0 || guess > 100);
                        pastGuesses.add(guess);
                        difference = Math.abs(guess - randomNumber);
                        if (guess == randomNumber) {
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
                    userChance = 20;
                    pastGuesses.clear();
                    win ^= win;
                    break;
                case 3:
                    randomNumber = r.nextInt(0, 101);
                    turn = r.nextBoolean();
                    guess = -1;
                    min = 0;
                    max = 100;
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
                        } else {
                            guess = (min + max) / 2;
                            pastGuesses.add(guess);
                            System.out.printf("%s \n%d\n", "It's AIs turn!\nAI guessed:", guess);
                            if (guess == randomNumber) {
                                System.out.println("AI won. You lost!");
                                win = true;
                            }
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
                        turn ^= true;
                    }
                    break;
                case 4:
                    ArrayList<Integer> guessPool = new ArrayList<>();
                    for (int i = 0; i < 100; i++) {
                        guessPool.add(i);
                    }
                    randomNumber = r.nextInt(0, 101);
                    turn = r.nextBoolean();
                    win = false;
                    int range = -1;
                    while (!win) {
                        if (turn) { // user
                            System.out.println("It's your turn!");
                            do {
                                System.out.println("Guess the number!");
                                System.out.println(pastGuesses);
                                guess = sc.nextInt();
                            } while (guess < 0 || guess > 100);
                            pastGuesses.add(guess);
                            if (guess == randomNumber) { // user win condition
                                System.out.println("You won. Congrats!");
                                win = true;
                            }
                        } else { // ai
                            guess = r.nextInt(guessPool.getFirst(), guessPool.getLast());
                            pastGuesses.add(guess);
                            System.out.printf("%s \n%d\n", "It's AIs turn!\nAI guessed:", guess); // ai win condition
                            if (guess == randomNumber) { // ai win condition
                                System.out.println("AI won. You lost!");
                                win = true;
                            }
                        }
                        difference = Math.abs(guess - randomNumber);
                        if (difference <= 3) {
                            System.out.println("Almost there! You're 1-3 off!");
                            range = 3;
                            for (int i = 0; i < guess - range; i++) {
                                guessPool.remove(Integer.valueOf(i));
                            }
                            for (int i = guess + range; i <= guessPool.getLast(); i++) {
                                guessPool.remove(Integer.valueOf(i));
                            }
                        } else if (difference <= 10) { // mid
                            System.out.println("Relatively close! You're 4-10 off");
                            for (int i = 0; i < guess - 10; i++) {
                                guessPool.remove(Integer.valueOf(i));
                            }
                            for (int i = guess + 10; i <= guessPool.getLast(); i++) {
                                guessPool.remove(Integer.valueOf(i));
                            }
                            range = 4;
                            for (int i = 0; i < range * 2; i++) {
                                guessPool.remove(Integer.valueOf(guess - range + i));
                            }
                        } else if (difference <= 20) {
                            System.out.println("Not so far away! You're 10-20 off");
                            range = 10;
                            for (int i = 0; i < guess - range * 2; i++) {
                                guessPool.remove(Integer.valueOf(i));
                            }
                            for (int i = guess + range * 2; i <= guessPool.getLast(); i++) {
                                guessPool.remove(Integer.valueOf(i));
                            }
                            range = 10;
                            for (int i = 0; i < range * 2; i++) {
                                guessPool.remove(Integer.valueOf(guess - range + i));
                            }
                        } else {
                            System.out.println("Far away, you're more than 20 off!");
                            range = 20;
                            for (int i = 0; i < range * 2; i++) {
                                guessPool.remove(Integer.valueOf(guess - range + i));
                            }
                        }
                        turn ^= true;
                        System.out.println(guessPool);
                    }
                    pastGuesses.clear();
                    break;
            }
        }
        System.out.println("Bye!");
        sc.close();
    }
}